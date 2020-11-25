package comparators;

import models.*;

import java.util.Comparator;
import java.util.List;

public class StreamTool {
	
	private static List<Animal> sortByCompareTo(List<Animal> animals){
		animals.sort(Animal::compareTo);
		return animals;
	}
	
	private static List<Animal> sortByAge(List<Animal> animals){
		animals.sort(new AnimalAgeComparator());
		return animals;
	}
	
	private static List<Animal> sortByAgeAndName(List<Animal> animals){
		Comparator<Animal> tcomp = new AnimalAgeComparator().thenComparing(new AnimalNameComparator());
		animals.sort(tcomp);
		return animals;
	}
	
	private static void sort(List<Animal> a) {
		a.stream().sorted().forEach(System.out::println);
	}
	
	private static void startWithB(List<Animal> a) {
		a.stream().filter((i) -> i.getName().startsWith("B")).forEach(System.out::println);
	}
	
	private static int countOfTigers(List<Animal> a) {
		return (int)a.stream().filter( i -> i instanceof Tiger).count();
	}
}
