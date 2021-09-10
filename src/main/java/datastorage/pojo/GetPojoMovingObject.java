package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import datastorage.jsonb.GetJsonbMovingObject;
import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;

/**
 * @author Isabel
 *
 */
public class GetPojoMovingObject {
	
	/**
	 * This method creates an new object of the class Farmer.
	 * @return deserialized as a new Tractor object of the farmer's information.
	 */
	public Farmer toDeserializeFarmer() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Farmer deserializeddf = jb.fromJson(jbp.toSerializeFarmer(), Farmer.class);
		return deserializeddf;	
	}
	
	/**
	 * This method creates an new object of the class Tractor.
	 * @return deserialized as a new Tractor object of the tractor's information.
	 */
	public Tractor toDeserializeTractor() {  	
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Tractor deserializeddt = jb.fromJson(jbp.toSerializeTractor(), Tractor.class);
		return deserializeddt;	
	}
	
	/**
	 * This method creates an new object of the class Harvester.
	 * @return deserialized as a new Tractor object of the harvester's information.
	 */
	public Harvester toDeserializeHarvester() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Harvester deserializeddh = jb.fromJson(jbp.toSerializeHarvester(), Harvester.class);
		return deserializeddh;	
	}
	
	/**
	 * This method creates an new object of the class Cultivator.
	 * @return deserialized as a new Tractor object of the cultivator's information.
	 */
	public Cultivator toDeserializeCultivator() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Cultivator deserializedch = jb.fromJson(jbp.toSerializeCultivator(), Cultivator.class);
		return deserializedch;	
	}
	
	/**
	 * This method creates an new object of the class DumpTruck.
	 * @return deserialized as a new Tractor object of the DumpTruck's information.
	 */
	public DumpTruck toDeserializeDumpTruck() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		DumpTruck deserializedddt = jb.fromJson(jbp.toSerializeDumpTruck(), DumpTruck.class);
		return deserializedddt;	
	}
	
	/**
	 * This method creates an new object of the class SeedDrill.
	 * @return deserialized as a new Tractor object of the SeedDrill's information.
	 */
	public SeedDrill toDeserializeSeedDrill() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		SeedDrill deserializeddsd = jb.fromJson(jbp.toSerializeSeedDrill(), SeedDrill.class);
		return deserializeddsd;	
	}

}
