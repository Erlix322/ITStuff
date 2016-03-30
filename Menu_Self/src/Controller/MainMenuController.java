package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ViewFactory.SuperView;
import ViewFactory.ViewFactory;
import animation.AnimationGenerator;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainMenuController implements Initializable, SuperView{
	
	ViewFactory vc;

	@FXML
	VBox MenuStrip;
	
	@FXML
	StackPane stackPane;
	
	@FXML
	BorderPane center;
	
	AnimationGenerator gen;
	
	@FXML
	ImageView MenuButton;
	
	@FXML
	Button btnPrakt;
	
	@FXML
	Button btnProxy;
	
	boolean isOpen = false;
	private static final int DEFAULT_STARTING_X_POSITION = 0;
    private static final int DEFAULT_ENDING_X_POSITION = -150;
	
	public MainMenuController(){
	gen = new AnimationGenerator();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		closeAnim();
		MenuButton.setImage(new Image("application/Menu-50.png"));		
	}
	
	
	
	public void closeAnim(){
		gen.applyTranslateAnimationOn(MenuStrip, 300, DEFAULT_STARTING_X_POSITION, DEFAULT_ENDING_X_POSITION);
		gen.applyTranslateAnimationOn(stackPane, 300, DEFAULT_STARTING_X_POSITION, DEFAULT_ENDING_X_POSITION);
		gen.applyRotationOn(MenuButton, 300, 180, 1);
		btnPrakt.setDisable(true); 
		btnProxy.setDisable(true);
		isOpen = false;
		
	}
	
	
	public void openAnim(){
		gen.applyTranslateAnimationOn(MenuStrip, 300, DEFAULT_ENDING_X_POSITION, DEFAULT_STARTING_X_POSITION);
		gen.applyTranslateAnimationOn(stackPane, 300, DEFAULT_ENDING_X_POSITION, DEFAULT_STARTING_X_POSITION);
		gen.applyRotationOn(MenuButton, 300, 180, 1);
		btnPrakt.setDisable(false); btnProxy.setDisable(false);
		isOpen = true;
	}
	
	@FXML
	public void onClickMenu(){
		if(isOpen){
			closeAnim();
		}else{
			openAnim();
		}
	}
	
	@FXML
	public void ItPrakt(){
		stackPane.getChildren().clear();
		stackPane.getChildren().add((vc.getScreen("ItPrakt")));	
		closeAnim();
	}	
	
	@FXML
	public void ProxyPrakt(){
		stackPane.getChildren().clear();
		stackPane.getChildren().add((vc.getScreen("ProxyPrakt")));	
		closeAnim();
	}	
	
	
	@Override
	public void setParent(ViewFactory fac) {
		vc = fac;		
	}
	
	

	
}
