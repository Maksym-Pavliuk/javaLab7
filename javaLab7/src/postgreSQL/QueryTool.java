package postgreSQL;


import models.*;

import java.sql.*;
import java.util.ArrayList;
public class QueryTool {
	
	private static final String create = "CREATE TABLE IF NOT EXISTS %s(id serial, %s, PRIMARY KEY(id));";
	private static final String drop = "DROP TABLE IF EXISTS %s";
	
	//----------
	
	private static final String insert = "INSERT INTO %s(%s) VALUES(%s);"; 	//C
	private static final String select = "SELECT * FROM %s;";				//R
	private static final String update = "UPDATE %s %s WHERE id = %d";		//U						
	private static final String delete = "DELETE FROM %s;";					//D

	//----------
	
	private static final String by_Id = "%s WHERE id = %d";
	private static final String alter_sequence = "ALTER SEQUENCE %s_id_seq RESTART;";
	
	//----------
	
	private static final String animal = "animal";
	private static final String cat = "cat";
	private static final String tiger = "tiger";
	
	private static final String animal_create_attribute = "name varchar(20), age int4, weight real"; 
	private static final String cat_create_attribute = animal_create_attribute + ", color varchar(20), category varchar(20)";
	private static final String tiger_create_attribute = cat_create_attribute + ", numOfEmployee int4";
	
	private static final String animal_attribute = "name, age, weight"; 
	private static final String cat_attribute = animal_attribute + ", color, category";
	private static final String tiger_attribute =  cat_attribute + ", numOfEmployee";
	
	private static final String animal_values = "\'%s\', %d, %f"; 
	private static final String cat_values = animal_values + ", \'%s\', \'%s\'";
	private static final String tiger_values = cat_values + ", %d";
	
	private static final String animal_update = "SET name = \'%s\', age = %d, weight = %f"; 
	private static final String cat_update = animal_update + ", color = \'%s\', category =  \'%s\'";
	private static final String tiger_update = cat_update + ", numOfEmployee = %d";
	
	//----------
	
	private static void executeUpdate(String query) throws SQLException {
		Connection connection = Connector.Connect();
		if (connection != null) {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Connector.Disconnect(connection);
		}
	}
	private static ResultSet executeQuery(String query) throws SQLException {
		Connection connection = Connector.Connect();
		ResultSet result = null;
		if (connection != null) {
		Statement statement = connection.createStatement();
		result = statement.executeQuery(query);
		statement.close();
		Connector.Disconnect(connection);
		}
		return result;
	}
	
	//----------
	
	public static void createAnimal() throws SQLException {
		executeUpdate(String.format(create, animal, animal_create_attribute));		
	}
	public static void createCat() throws SQLException {
		executeUpdate(String.format(create , cat, cat_create_attribute));
	}
	public static void createTiger() throws SQLException {
		executeUpdate(String.format(create, tiger, tiger_create_attribute));
	}
	
	public static void dropAnimal() throws SQLException {
		executeUpdate(String.format(drop, animal));		
	}
	public static void dropCat() throws SQLException {
		executeUpdate(String.format(drop, cat));
	}
	public static void dropTiger() throws SQLException {
		executeUpdate(String.format(drop, tiger));
	}	
	
	//----------
	
	public static void insertAnimal(Animal a) throws SQLException {	
		executeUpdate(String.format(String.format(insert, animal, animal_attribute, animal_values),
				a.getName(), a.getAge(), a.getWeight()));
	}
	public static void insertCat(Cat c) throws SQLException {	
		executeUpdate(String.format(String.format(insert, cat, cat_attribute, cat_values),
				c.getName(), c.getAge(), c.getWeight(), c.getColor(), c.getCategory()));
	}
	public static void insertTiger(Tiger t) throws SQLException {
		executeUpdate(String.format(String.format(insert, tiger, tiger_attribute, tiger_values),
				t.getName(), t.getAge(), t.getWeight(), t.getColor(), t.getCategory(), t.getNumOfEatenEmployees()));
	}
	
	//----------
	
	public static ArrayList<Animal> selectAnimal() throws SQLException {
		ArrayList<Animal> list = new ArrayList<Animal>();
		ResultSet set= executeQuery(String.format(select, animal));
		while(set.next()) 
			list.add(new Animal(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4)));
		return list;
	}
	public static ArrayList<Cat> selectCat() throws SQLException {
		ArrayList<Cat> list = new ArrayList<Cat>();
		ResultSet set = executeQuery(String.format(select, cat));
		while(set.next()) 
			list.add(new Cat(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4),
					set.getString(5), set.getString(6)));
		return list;
	}
	public static ArrayList<Tiger> selectTiger() throws SQLException {
		ArrayList<Tiger> list = new ArrayList<Tiger>();
		ResultSet set = executeQuery(String.format(select, tiger));
		while(set.next()) 
			list.add(new Tiger(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4),
					set.getString(5), set.getString(6),
					set.getInt(7)));
		return list;
	}
	
	public static Animal selectAnimalById(int id) throws SQLException {
		Animal a = null;
		ResultSet set = executeQuery(String.format(String.format(select, by_Id), 
				animal, id));
		if (set.next()) 
			a = new Animal(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4));
		return a;
	}
	public static Cat selectCatById(int id) throws SQLException {
		Cat c = null;
		ResultSet set = executeQuery(String.format(String.format(select, by_Id), 
				cat, id));
		if (set.next()) 
			c = new Cat(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4),
					set.getString(5), set.getString(6));
		return c;
	}
	public static Tiger selectTigerById(int id) throws SQLException {
		Tiger t = null;
		ResultSet set = executeQuery(String.format(String.format(select, by_Id),
				tiger, id));
		if (set.next()) 
			t = new Tiger(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4),
					set.getString(5), set.getString(6),
					set.getInt(7));
		return t;
	}
	
	//----------
	
	public static void updateAnimal(Animal a) throws SQLException {
		executeUpdate(String.format(String.format(update, animal, animal_update, a.getId()),
				a.getName(), a.getAge(), a.getWeight()));
	}
	public static void updateCat(Cat c) throws SQLException {
		executeUpdate(String.format(String.format(update, cat, cat_update, c.getId()),
				c.getName(), c.getAge(), c.getWeight(), c.getColor(), c.getCategory()));
	}
	public static void updateTiger(Tiger t) throws SQLException {
		executeUpdate(String.format(String.format(update, tiger, tiger_update, t.getId()),
				t.getName(), t.getAge(), t.getWeight(), t.getColor(), t.getCategory(), t.getNumOfEatenEmployees()));
	}
	
	//----------
	
	public static void deleteAnimal() throws SQLException {
		executeUpdate(String.format(delete, animal));
	}
	public static void deleteCat() throws SQLException {
		executeUpdate(String.format(delete, cat));
	}
	public static void deleteTiger() throws SQLException {
		executeUpdate(String.format(delete, tiger));
	}
	
	public static void deleteAnimalById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				animal, id));
	}
	public static void deleteCatById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				cat, id));
	}
	public static void deleteTigerById(int id) throws SQLException {
		executeUpdate(String.format(String.format(delete, by_Id),
				tiger, id));
	}
	
	//----------
	
	public static void alterAnimal() throws SQLException {
		executeUpdate(String.format(alter_sequence, animal));
	}
	public static void alterCat() throws SQLException {
		executeUpdate(String.format(alter_sequence, cat));
	}
	public static void alterTiger() throws SQLException {
		executeUpdate(String.format(alter_sequence, tiger));
	}
	
	//----------
	
	private static final String animal_orderBy = "select * from animal order by(name);";
	private static final String animal_startWithB = "select * from animal where name like 'B%';";
	private static final String animal_ageMoreAvg = "select * from animal where age > (select avg(age) from animal);";
	
	public static ResultSet sortAnimal() throws SQLException {
		return executeQuery(animal_orderBy);
	}
	public static ResultSet startWithB() throws SQLException {
		return executeQuery(animal_startWithB);
	}
	public static ResultSet ageMoreThanAvg() throws SQLException {
		return executeQuery(animal_ageMoreAvg);
	}
}
