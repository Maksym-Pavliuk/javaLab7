package serialize;

import models.*;

import java.io.IOException;
import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;



public class XMLSerializer<T extends Animal> implements Serializer<T> {
    
	private static XmlMapper mapper;
    private Class<T> myClass;
    
    public XMLSerializer(Class<T> myClass) {
        this.myClass = myClass;
        mapper = new XmlMapper();
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
	public T Deserialize(File file) throws IOException {
		try {
            return mapper.readValue(file, myClass);
        } 
		catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
	}

}
