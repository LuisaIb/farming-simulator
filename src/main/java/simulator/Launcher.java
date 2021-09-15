package simulator;

import gameboard.objects.Farmer;
import gui.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * @author Luisaibele, Isabel
 *
 */
public class Launcher extends Application {
	
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
		
		
//	  
	  Farmer f = new Farmer();
	 System.out.println(f.getX());
		
	}
}
