package models;

import validation.CategoryAttribute;
import validation.ColorAttribute;

public class Cat extends Animal{
	
	@ColorAttribute(enumClazz = Color.class, message = "Unknown color")
	protected String color;
	
	@CategoryAttribute(enumClazz = Categories.class, message = "Unknown category")
	protected String category;
	
	//----------
	
	public Cat() {
		super();
	};
	public Cat(int id, String name, int age, double weight, String color, String CATegory) {
		super(id, name, age, weight);
		this.category = CATegory;
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}	
	public String getCategory() {
		return category;
	}
	
	public void setColor(String color) {
		this.color = color;
}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//----------
	
	@Override
	public String toString() {
		return super.toString() + " Color: " + color + " Category: " + category; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 33;
		int result = super.hashCode();
		result = prime * result + color.length();
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
		Cat temp = (Cat)obj;
		if(this.name != temp.name || this.weight != temp.weight || this.age != temp.age ||
		   this.category != temp.category || this.color != temp.color)
			return false;		
 		return true;
	}
	
	//----------
	
	public static class Builder{

		private Cat newCat;
		
		public Builder(){
			newCat = new Cat();
		}
		
		public Builder addName(String name){
			newCat.name = name;
			return this;
		}

		public Builder addWeight(double weight){
			newCat.weight = weight;
			return this;
		}

		public Builder addAge(int age){
			newCat.age = age;
			return this;
		}
		

		public Builder addColor(String color){
			newCat.color = color;
			return this;
		}
		

		public Builder addCategory(String category){
			newCat.category = category;
			return this;
		}
		
		public Cat Build() {
			return newCat;
		}
	}
	
}
