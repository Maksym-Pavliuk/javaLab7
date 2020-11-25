package models;

import javax.validation.constraints.*;

public class Tiger extends Cat {
	
		@PositiveOrZero(message = "Must be greater than 0 or 0!")
		private int numOfEatenEmployees;
	
		//----------
		
		public Tiger() {
			super();
		};
		public Tiger(int id, String name, int age, double weight, String color, String CATegory, int numOfEatenEmployees) {
			super(id, name, age, weight, color, CATegory);
			this.numOfEatenEmployees = numOfEatenEmployees;
		}
		
		public int getNumOfEatenEmployees() {
			return numOfEatenEmployees;
		}
		
		public void setNumOfEatenEmployees(int numOfEatenEmployees) {
			this.numOfEatenEmployees = numOfEatenEmployees;
		}
		
		//----------
		
		@Override
		public String toString() {
			return super.toString() + " NumOfEatenEmployees: "+ numOfEatenEmployees; 
		}
		
		@Override
		public int hashCode() {
			final int prime = 41;
			int result = super.hashCode();
			result = prime * result + this.numOfEatenEmployees;
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
			Tiger temp = (Tiger)obj;
			if(this.name != temp.name || this.weight != temp.weight || this.age != temp.age ||
			   this.category != temp.category || this.color != temp.color || 
			   this.numOfEatenEmployees != temp.numOfEatenEmployees)
				return false;		
	 		return true;
		}
		
		public static class Builder{
			
			private Tiger newTiger;

			public Builder(){
				newTiger = new Tiger();
			}
			
			public Builder addName(String name){
				newTiger.name = name;
				return this;
			}
			
			public Builder addWeight(double weight){
				newTiger.weight = weight;
				return this;
			}

			public Builder addAge(int age){
				newTiger.age = age;
				return this;
			}

			public Builder addColor(String color){
				newTiger.color = color;
				return this;
			}
			
			public Builder addCategory(String category){
				newTiger.category = category;
				return this;
			}
			
			public Builder addEatenEmployees(int numOfEatenEmployees){
				newTiger.numOfEatenEmployees = numOfEatenEmployees;
				return this;
			}

			public Tiger Build() {
				return newTiger;
			}
		}
}
