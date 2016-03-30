package ViewFactory;

import java.io.IOException;
import java.util.HashMap;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class ViewFactory {

	HashMap<String,Node> views = new HashMap<String,Node>();
	
	private void addScreen(String name, Node node){
		views.put(name, node);
	}
	
	public void loadScreen(String name, String node){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(node));
			Parent loadScreen = (Parent)loader.load();
			SuperView cs = ((SuperView)loader.getController());	
			cs.setParent(this); 												//??
			addScreen(name,loadScreen);				
		} catch (IOException e) {			
			e.printStackTrace();
			
			
		}
	}
	
	public Node getScreen(String name){
		return views.get(name);
	}
	
}
