package simulator;

import gui.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class contains the main method to start the game.
 * @author Luisaibele, Isabel, Judith
 *
 */
public class Launcher extends Application {
	/**
	 * This is the main class to start the game.
	 *
	 * @param args arguments that can be handed to the game when started
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * This method starts the farmer simulator by showing the mainStage.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		ViewManager viewManager = new ViewManager();
		viewManager.initializeStage();
	}
}
