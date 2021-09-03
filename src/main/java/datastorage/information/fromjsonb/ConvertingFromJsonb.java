/**
 * 
 */
package datastorage.information.fromjsonb;

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
		siv.GetSavingInformationFieldtiles();// Exception
		siv.GetSavingInformationTank();
		
	// all positions
	GetSavingInformationPosition sip = new GetSavingInformationPosition();
		sip.GetSavingInformationFarmer();
		sip.GetSavingInformationTractor();
		sip.GetSavingInformationHarvester();// Exception
			
		
	}
	
}
