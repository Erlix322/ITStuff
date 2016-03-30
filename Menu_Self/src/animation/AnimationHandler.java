package animation;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationHandler {

	public void einblenden(Node object, double from, double to){
		FadeTransition fade = new FadeTransition(Duration.millis(1000),object);
		fade.setFromValue(from);
        fade.setToValue(to);
        fade.setAutoReverse(true);
        fade.setCycleCount(1);
        fade.play();
	}
	
	public void moveTo(Node node, double from, double to){
		 TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), node);
	        translateTransition.setFromX(from);
	        translateTransition.setToX(to);
	        translateTransition.setCycleCount(1);
	        translateTransition.setAutoReverse(true);
	        translateTransition.play();      

	}
	
	
}
