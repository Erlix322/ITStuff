package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import ViewFactory.SuperView;
import ViewFactory.ViewFactory;

import application.ITPraktTask;


public class ITController implements SuperView{

	ViewFactory vc;

	private String url = null;
	private String request;
	private int port = 80;
	
	@FXML
	ProgressBar progress;
	
	@FXML
	Button send;
	
	@FXML
	TextArea content;
	
	@FXML
	TextField ta;
	
	@FXML
	public void onClick(){
		url = ta.getText();
		
		ITPraktTask mt = new ITPraktTask(ta.getText(),port);
		Thread th = new Thread(mt);
		
		if(th.isAlive()){
			th.interrupt();
		}
		
		content.textProperty().bind(mt.messageProperty());
		progress.progressProperty().bind(mt.progressProperty());
		th.start();		
		
	}

	
	@Override
	public void setParent(ViewFactory fac) {
		vc = fac;
	}

	
	
}
