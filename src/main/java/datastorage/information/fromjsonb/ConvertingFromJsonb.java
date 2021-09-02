/**
 * 
 */
package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoPosition;

/**
 * @author Isabel
 * This class deals with the creation of new c
 */
public class ConvertingFromJsonb {
	/**
	 * This method is converting all the data into a class object
	 */
	public void GetSavingInformation() {
	//all numeric values
	GetSavingInformationValue siv = new GetSavingInformationValue();
		siv.GetSavingInformationGame();
//		siv.GetSavingInformationLevel();
		siv.GetSavingInformationFieldtiles();
		siv.GetSavingInformationFieldtiles();// Exception
		
	// all positions
	GetSavingInformationPosition sip = new GetSavingInformationPosition();
		sip.GetSavingInformationFarmer();
		sip.GetSavingInformationTractor();
		sip.GetSavingInformationHarvester();// Exception
			
		
	}
	
}
