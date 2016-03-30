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
	
	public static String screen1ID = "ItPrakt";
	public static String screen1File = "/View/ItPraktTask.fxml";
	public static String screen2ID = "main";
	public static String screen2File = "/View/MainMenu.fxml";
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			//Initialize Views in Hashmap
			ViewFactory sc = new ViewFactory();
			sc.loadScreen(Main.screen1ID,Main.screen1File);
			sc.loadScreen(Main.screen2ID,Main.screen2File);
			
		    
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
	                System.out.println("HUHU");
	            	Platform.exit();
	                System.exit(0);
	            }
	        });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
