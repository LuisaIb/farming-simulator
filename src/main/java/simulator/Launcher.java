package simulator;

import gui.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author 
 *
 */
public class Launcher extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ViewManager viewManager = new ViewManager();
		viewManager.initializeStage();
	}
}
