package serialize;


import models.*;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONSerializer<T extends Animal> implements Serializer<T> {
	ObjectMapper mapper;
	Class<T> myClass;
	
	public JSONSerializer(Class<T> myClass) {
		mapper = new ObjectMapper();
		this.myClass = myClass;
	}
	
	@Override
	public void Serialize(T obj, File file) throws IOException {
		try {
			mapper.writeValue(file, obj);
		} 
		catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }	
	}
	
	@Override
	public T Deserialize(File file) {
		try {
            return mapper.readValue(file, myClass);
        } 
		catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
	}
}
