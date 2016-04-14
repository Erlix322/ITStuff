package application;
	
import java.io.IOException;

import ViewFactory.ViewFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	Scene scene;
	Stage stage;
	ViewFactory sc;
	
	public static String screen1ID = "ItPrakt";
	public static String screen1File = "/View/ItPraktTask.fxml";
	public static String screen2ID = "main";
	public static String screen2File = "/View/MainMenu.fxml";
	public static String screen3ID = "ProxyPrakt";
	public static String screen3File = "/View/Proxy.fxml";
	public static String screen4ID = "lol";
	public static String screen4File = "/View/Diagram.fxml";
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			//Initialize Views in Hashmap
			sc = new ViewFactory();
			loadViews();
		    
			Parent root = (Parent) sc.getScreen("main");
	        primaryStage.setTitle("MenuStrip");
	        scene = new Scene(root);
	        scene.getStylesheets().add("application/application.css");
	        primaryStage.setScene(scene);
	        primaryStage.show(); 	        
	        stage = primaryStage;
	        
	        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            @Override
	            public void handle(WindowEvent event) {
	               	Platform.exit();
	                System.exit(0);
	            }
	        });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void loadViews(){
		
		sc.loadScreen(Main.screen1ID,Main.screen1File);
		sc.loadScreen(Main.screen2ID,Main.screen2File);
		sc.loadScreen(Main.screen3ID,Main.screen3File);
		sc.loadScreen(Main.screen4ID,Main.screen4File);
	}
}
