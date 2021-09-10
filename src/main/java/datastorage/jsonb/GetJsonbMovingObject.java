package datastorage.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

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
public class GetJsonbMovingObject {

	/**
	 * This method gets the position of the farmer of the class...
	 * @return serialized as a JSONB object of the farmer's position
	 */
	public String toSerializeFarmer() { 
		Farmer sf = new Farmer();
		sf.getX();
		sf.getY();
		sf.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsf = jsonb.toJson(sf);
		return serializedsf;
	}
	
	/**
	 * This method gets the position of the tractor of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeTractor() { 
		Tractor st = new Tractor();
		st.getX();
		st.getY();
		st.isSelected();
		st.getPetrolTankFillLevel();
		st.isAttachement();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedst = jsonb.toJson(st);
		return serializedst;
	}
	
	/**
	 * This method gets the position of the harvester of the class...
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeHarvester() { 
		Harvester sh = new Harvester();
		sh.getX();
		sh.getY();
		sh.isSelected();
		sh.getPetrolTankFillLevel();
		sh.getGrainTankFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsh = jsonb.toJson(sh);
		return serializedsh;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeCultivator() { 
		Cultivator sc = new Cultivator();
		sc.getX();
		sc.getY();
		sc.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsc = jsonb.toJson(sc);
		return serializedsc;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeDumpTruck() { 
		DumpTruck sdt = new DumpTruck();// leeren konstruktor erstellen
		sdt.getX();
		sdt.getY();
		sdt.isSelected();
		sdt.getGrainFillLevel();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedsdt = jsonb.toJson(sdt);
		return serializedsdt;
	}
	
	/**
	 * This method gets the information of the Cultivator.
	 * @return serialized as a JSONB object of the tractor's positions
	 */
	public String toSerializeSeedDrill() { 
		SeedDrill ssd = new SeedDrill();
		ssd.getX();
		ssd.getY();
		ssd.isSelected();
		Jsonb jsonb = JsonbBuilder.create();
		String serializedssd = jsonb.toJson(ssd);
		return serializedssd;
	}
	
}
