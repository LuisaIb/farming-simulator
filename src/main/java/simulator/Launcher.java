package simulator;

import gameboard.objects.Farmer;
import gui.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * this class is meant to be the class to start the game
 * @author Luisaibele, Isabel
 *
 */
public class Launcher extends Application {
	
	/**
	 * this is the main class to start the game
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 *this method is supposed to start the farmer simulator
	 */
	@Override
	public void start(Stage stage) throws Exception {
		ViewManager viewManager = new ViewManager();
		viewManager.initializeStage();
			  
	  Farmer f = new Farmer();
	 System.out.println(f.getX());
		
	}
}
