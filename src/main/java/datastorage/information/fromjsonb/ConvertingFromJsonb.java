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
		siv.GetSavingInformationLevel();
		siv.GetSavingInformationFieldtiles();// Exception
		siv.GetSavingInformationSilo();
		siv.GetSavingInformationCourtTrade();
		
	// all positions
	GetSavingInformationMovingObject sip = new GetSavingInformationMovingObject();
		sip.GetSavingInformationFarmer();
		sip.GetSavingInformationTractor();
		sip.GetSavingInformationHarvster();// Exception
		sip.GetSavingInformationCultivator();
		sip.GetSavingInformationDumpTruck();
		sip.GetSavingInformationSeedDrill();	
	}




	
}
