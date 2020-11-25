package models;

import java.io.Serializable;

import javax.validation.constraints.*;

public class Animal implements Serializable, Comparable<Animal> {

	protected int id;
	
	@Size(min = 1, max = 20, message = "Must be between 1 and 20 characters!")
	protected String name;
	
	@Positive(message = "Must be great than 0")
	protected int age;
	
	@Positive(message = "Must be great than 0")
	protected double weight;
	
	//----------
	
	public Animal() {};
	public Animal(int id, String name, int age, double weight) {
		this.id = id;
		this.name = name;
		if (age > 0)
			this.age = age;
		if (weight > 0)
			this.weight = weight;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getWeight() {
		return weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		if (age > 0)
			this.age = age;
	}
	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
	}
	
	//----------
	
	@Override
	public int hashCode() {
		final int prime = 27;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (int)weight;
		result = prime * result + name.length();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.hashCode() != obj.hashCode())
				return false;
		if (this.getClass() != obj.getClass())
			return false;
		Animal temp = (Animal)obj;
		if(this.name != temp.name || this.weight != temp.weight || this.age != temp.age )
			return false;		
 		return true;
	}
	
	@Override
	public String toString() {
		return "Name:" + name + " Age: " + age + " Weight: " + weight; 
	}
	
	//----------
	
	@Override
	public int compareTo(Animal a) {
		if (age == a.age) {
			if (weight == a.weight) {
				if (name.length() == a.name.length()) {
					return name.compareTo(a.name);
				}
				return name.length() - a.name.length();
			}
			return (int)(weight - a.weight);
		}
		return age - a.age;
	}
	
	//----------
	
	public static class Builder{
		
		private Animal newAnimal;

		public Builder(){
			newAnimal = new Animal();
		}

		public Builder addName(String name){
			newAnimal.name = name;
			return this;
		}
		
		public Builder addWeight(double weight){
			newAnimal.weight = weight;
			return this;
		}
		
		public Builder addAge(int age){
			newAnimal.age = age;
			return this;
		}
		
		public Animal Build() {
			return newAnimal;
		}
	}
}
