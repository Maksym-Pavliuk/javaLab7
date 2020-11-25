package serialize;

import models.*;

import java.io.IOException;
import java.io.File;

public interface Serializer<T extends Animal> {
	void Serialize(T obj, File file) throws IOException;
	T Deserialize(File file) throws IOException;
}
