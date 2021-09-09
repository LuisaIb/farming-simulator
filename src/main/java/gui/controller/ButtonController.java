/**
 * 
 */
package gui.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class ButtonController {

	LevelOfDifficulty lod = new LevelOfDifficulty();
	
	public EventHandler<Event> setDifficultyLevel1 = event -> {

		lod.setLevel(1);
		
	};
	
	public EventHandler<Event> setDifficultyLevel2 = event -> {

		lod.setLevel(2);
		
	};
	
	public EventHandler<Event> setDifficultyLevel3 = event -> {

		lod.setLevel(3);
	};
}
