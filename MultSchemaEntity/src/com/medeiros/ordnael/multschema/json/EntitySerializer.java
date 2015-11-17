package com.medeiros.ordnael.multschema.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.hibernate.collection.internal.PersistentBag;

public class EntitySerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		//System.out.println("-> "+value);
		if (value!=null && (!PersistentBag.class.equals(value.getClass()) && value.getClass().toString().indexOf("javassist")==(-1))) {
			jgen.writeObject(value);
		} else {
			jgen.writeNull();
		}
		
	}

}
