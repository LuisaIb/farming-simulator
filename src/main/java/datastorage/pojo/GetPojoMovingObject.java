package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;
import simulator.Game;

/**
 * @author Isabel
 *
 */
public class GetPojoMovingObject {
	
	/**
	 * This method creates an new object of the class Farmer.
	 * @return deserialized as a new Tractor object of the farmer's information.
	 */
	public Farmer toDeserializeFarmer(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		Farmer deserializeddf = jb1.fromJson(jb, Farmer.class);
		return deserializeddf;	
	}
	
	/**
	 * This method creates an new object of the class Tractor.
	 * @return deserialized as a new Tractor object of the tractor's information.
	 */
	public Tractor toDeserializeTractor(String jb) {  	
		Jsonb jb1 = JsonbBuilder.create();
		Tractor deserializeddt = jb1.fromJson(jb, Tractor.class);
		return deserializeddt;	
	}
	
	/**
	 * This method creates an new object of the class Harvester.
	 * @return deserialized as a new Tractor object of the harvester's information.
	 */
	public Harvester toDeserializeHarvester(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		Harvester deserializeddh = jb1.fromJson(jb, Harvester.class);
		return deserializeddh;	
	}
	
	/**
	 * This method creates an new object of the class Cultivator.
	 * @return deserialized as a new Tractor object of the cultivator's information.
	 */
	public Cultivator toDeserializeCultivator(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		Cultivator deserializedch = jb1.fromJson(jb, Cultivator.class);
		return deserializedch;	
	}
	
	/**
	 * This method creates an new object of the class DumpTruck.
	 * @return deserialized as a new Tractor object of the DumpTruck's information.
	 */
	public DumpTruck toDeserializeDumpTruck(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		DumpTruck deserializedddt = jb1.fromJson(jb, DumpTruck.class);
		return deserializedddt;	
	}
	
	/**
	 * This method creates an new object of the class SeedDrill.
	 * @return deserialized as a new Tractor object of the SeedDrill's information.
	 */
	public SeedDrill toDeserializeSeedDrill(String jb) {  
		Jsonb jb1 = JsonbBuilder.create();
		SeedDrill deserializeddsd = jb1.fromJson(jb, SeedDrill.class);
		return deserializeddsd;	
	}

}
