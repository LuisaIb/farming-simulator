package datastorage.information.fromjsonb;

import datastorage.pojo.GetPojoMovingObject;
import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;

/**
 * @author Isabel
 * * This class converts the JSONB file into a class object and generates new constructor values
 */
public class GetSavingInformationMovingObject {
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the farmer.
	 * It implements a new position (x and y value) of the farmer.
	 */
	public Farmer GetSavingInformationFarmer() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		Farmer deserializedX = gpp.toDeserializeFarmer();
		int x = deserializedX.getX();
		
		Farmer deserializedY = gpp.toDeserializeFarmer();
		int y = deserializedY.getY();
		
		Farmer deserializedSelected = gpp.toDeserializeFarmer();
		boolean selected = deserializedSelected.isSelected();
		
		Farmer updatedFarmer = new Farmer(x, y, selected);
		return updatedFarmer;
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the tractor.
	 * It implements a new position (x and y value) of the tractor.
	 */
	public Tractor GetSavingInformationTractor() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		Tractor deserializedX = gpp.toDeserializeTractor();
		int x = deserializedX.getX();
		
		Tractor deserializedY = gpp.toDeserializeTractor();
		int y = deserializedY.getY();
		
		Tractor deserializedSelected = gpp.toDeserializeTractor();
		boolean selected = deserializedSelected.isSelected();
		
		Tractor deserializedPetrolTankFillLevel = gpp.toDeserializeTractor();
		int petrolTankFillLevel = deserializedPetrolTankFillLevel.getPetrolTankFillLevel();
		
		Tractor deserializedAttachement = gpp.toDeserializeTractor();
		boolean attachement = deserializedAttachement.isAttachement();
		
		Tractor updatedTractor = new Tractor(x, y, selected, petrolTankFillLevel, attachement);
		return updatedTractor;

	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public Harvester GetSavingInformationHarvster() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		Harvester deserializedX = gpp.toDeserializeHarvester();
		int x = deserializedX.getX();
		
		Harvester deserializedY = gpp.toDeserializeHarvester();
		int y = deserializedY.getY();
		
		Harvester deserializedSelected = gpp.toDeserializeHarvester();
		boolean selected = deserializedSelected.isSelected();
		
		Harvester deserializedPetrolTankFillLevel = gpp.toDeserializeHarvester();
		int petrolTankFillLevel = deserializedPetrolTankFillLevel.getPetrolTankFillLevel();
		
		Harvester deserializedGrainTankFillLevel = gpp.toDeserializeHarvester();
		int grainTankFillLevel = deserializedGrainTankFillLevel.getGrainTankFillLevel();
		
		Harvester updatedHarvester = new Harvester(x, y, selected, petrolTankFillLevel, grainTankFillLevel);
		return updatedHarvester;
		
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public Cultivator GetSavingInformationCultivator() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		Cultivator deserializedX = gpp.toDeserializeCultivator();
		int x = deserializedX.getX();
		
		Cultivator deserializedY = gpp.toDeserializeCultivator();
		int y = deserializedY.getY();
		
		Cultivator deserializedSelected = gpp.toDeserializeCultivator();
		boolean selected = deserializedSelected.isSelected();
		
		Cultivator updatedCultivator = new Cultivator(x, y, selected);
		return updatedCultivator;
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public DumpTruck GetSavingInformationDumpTruck() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		DumpTruck deserializedX = gpp.toDeserializeDumpTruck();
		int x = deserializedX.getX();
		
		DumpTruck deserializedY = gpp.toDeserializeDumpTruck();
		int y = deserializedY.getY();
		
		DumpTruck deserializedSelected = gpp.toDeserializeDumpTruck();
		boolean selected = deserializedSelected.isSelected();
		
		DumpTruck deserializedGrainFillLevel = gpp.toDeserializeDumpTruck();
		int grainFillLevel = deserializedGrainFillLevel.getGrainFillLevel();
		
		DumpTruck updatedDumpTruck = new DumpTruck(x, y, selected, grainFillLevel);
		return updatedDumpTruck;
	}
	
	/**
	 * This method deserialize the JSONB file. It is also possible to get the position of the harvester.
	 * It implements a new position (x and y value) of the harvester.
	 */
	public SeedDrill GetSavingInformationSeedDrill() {
		GetPojoMovingObject gpp = new GetPojoMovingObject();	
		SeedDrill deserializedX = gpp.toDeserializeSeedDrill();
		int x = deserializedX.getX();
		
		SeedDrill deserializedY = gpp.toDeserializeSeedDrill();
		int y = deserializedY.getY();
		
		SeedDrill deserializedSelected = gpp.toDeserializeSeedDrill();
		boolean selected = deserializedSelected.isSelected();
		
		SeedDrill updatedSeedDrill = new SeedDrill(x, y, selected);
		return updatedSeedDrill;
	}
	
}
