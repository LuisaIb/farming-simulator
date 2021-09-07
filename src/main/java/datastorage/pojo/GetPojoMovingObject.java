/**
 * 
 */
package datastorage.pojo;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import datastorage.jsonb.GetJsonbMovingObject;
import machines.Cultivator;
import machines.DumpTruck;
import machines.Farmer;
import machines.Harvester;
import machines.SeedDrill;
import machines.Tractor;

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
		Farmer deserializedgbf = jb.fromJson(jbp.toSerializeFarmer(), Farmer.class);
		return deserializedgbf;	
	}
	
	/**
	 * This method creates an new object of the class Tractor.
	 * @return deserialized as a new Tractor object of the tractor's information.
	 */
	public Tractor toDeserializeTractor() {  	
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Tractor deserializedgbt = jb.fromJson(jbp.toSerializeTractor(), Tractor.class);
		return deserializedgbt;	
	}
	
	/**
	 * This method creates an new object of the class Harvester.
	 * @return deserialized as a new Tractor object of the harvester's information.
	 */
	public Harvester toDeserializeHarvester() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Harvester deserializedgbh = jb.fromJson(jbp.toSerializeHarvester(), Harvester.class);
		return deserializedgbh;	
	}
	
	/**
	 * This method creates an new object of the class Cultivator.
	 * @return deserialized as a new Tractor object of the cultivator's information.
	 */
	public Cultivator toDeserializeCultivator() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		Cultivator deserializedgbh = jb.fromJson(jbp.toSerializeCultivator(), Cultivator.class);
		return deserializedgbh;	
	}
	
	/**
	 * This method creates an new object of the class DumpTruck.
	 * @return deserialized as a new Tractor object of the DumpTruck's information.
	 */
	public DumpTruck toDeserializeDumpTruck() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		DumpTruck deserializedgbh = jb.fromJson(jbp.toSerializeDumpTruck(), DumpTruck.class);
		return deserializedgbh;	
	}
	
	/**
	 * This method creates an new object of the class SeedDrill.
	 * @return deserialized as a new Tractor object of the SeedDrill's information.
	 */
	public SeedDrill toDeserializeSeedDrill() {  
		GetJsonbMovingObject jbp = new GetJsonbMovingObject();
		Jsonb jb = JsonbBuilder.create();
		SeedDrill deserializedgbh = jb.fromJson(jbp.toSerializeSeedDrill(), SeedDrill.class);
		return deserializedgbh;	
	}

}
// Klassen müssen angepasst werden