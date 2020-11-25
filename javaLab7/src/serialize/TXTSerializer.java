package serialize;

import models.*;

import java.io.IOException;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;

public class TXTSerializer implements Serializer<Animal> {

	public void Serialize(Animal obj, File file) throws IOException {
		try(FileWriter fw = new FileWriter(file)){
			String str = "Name: " + ((Animal) obj).getName() + " Age: " + ((Animal) obj).getAge() + " Weight: " + ((Animal) obj).getWeight();
			fw.write(str);
		}
		catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
	}

	@Override
	public Animal Deserialize(File file) throws IOException {
		try(FileReader fr = new FileReader(file)){
			String str = "";
			int c;
			while((c = fr.read()) != -1)
				str += (char)c;
			String[] values = str.split(" ");
			return  new Animal(-1, values[1], Integer.parseInt(values[3]), Double.parseDouble(values[5])) ;
		}
		catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
	}

}
