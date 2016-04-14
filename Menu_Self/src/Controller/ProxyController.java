package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Base64.Encoder;

import ViewFactory.SuperView;
import ViewFactory.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProxyController implements SuperView{

	ViewFactory fc;
	
	@FXML
	TextField textField;
	
	@FXML
	TextArea textArea;
	
	
	@Override
	public void setParent(ViewFactory fac) {
		fc = fac;
		
	}
	
	@FXML
	public void onClick(){
		try {
			String webPage = "http://www2.htw-dresden.de/~jvogt/it1/test.pdf";
			String name = "it1";
			String password = "VLIT1";

			
			
			
			
			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			
			//---------------------------
			Encoder e = Base64.getEncoder();
			byte[] byteEnc = e.encode(authString.getBytes());
			String stringEnc = new String(byteEnc);
			
			String request = "GET /~jvogt/it1/test.pdf HTTP/1.1"+"\r\n"+
					  "Host: www2.htw-dresden.de"+"\r\n"+
					  "Authorization: Basic "+stringEnc+"\r\n\r\n";
			System.out.println("Request: "+request);

			
			Socket sock = new Socket("www2.htw-dresden.de",80);
	    	PrintWriter pw = new PrintWriter(sock.getOutputStream());
	    	pw.write(request);
	    	pw.flush();
			InputStream is = sock.getInputStream();
			BufferedReader br = new BufferedReader( new InputStreamReader(is));

			String result;
			System.out.println("*** BEGIN ***");
		
			while((result = br.readLine()) != null){
				System.out.println(result);
			}
			
			
			
			
			
			
			System.out.println("*** END ***");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	

}
