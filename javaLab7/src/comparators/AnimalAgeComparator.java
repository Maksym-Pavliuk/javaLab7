package comparators;

import models.*;

import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {

		@Override
		public int compare(Animal a1, Animal a2) {
			return a1.getAge() - a2.getAge();
		}
}
