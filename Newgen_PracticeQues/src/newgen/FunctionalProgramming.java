package newgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalProgramming {
	
	
	
	public static void main(String[] args) {
		
		Predicate<Integer> isEven = n-> n%2==0;
		Predicate<Integer> isMultipleOf3 = n-> n%3==0;
		Predicate<Integer> isMultipleOf4 = n-> n%4==0;
		
		Predicate<Integer> mathCheck = isEven.and(isMultipleOf3).or(isMultipleOf4);
		
//		Predicate<Person> isSeniorCitizen = person -> person.Age > 60;
		
//		System.out.println(isEven.test(10));
//		System.out.println(isEven.test(9));
		
		Consumer<String> upperCaseShift = msg -> {
			String upperStringMsg =  msg.toUpperCase();
			upperStringMsg+="_Processing";
			System.out.println(upperStringMsg);
		};
		
		Consumer<String> appendThings = s -> {
			s+="_Processed";
			System.out.println(s);
		};
		
//		upperCaseShift.accept("Test");
		
		
		List<String> listOfStr = Arrays.asList("abd","asdee","1g1f");
		
//		listOfStr.stream()
//		.limit(2)
//		.forEach(upperCaseShift.andThen(appendThings));
		
		
		Supplier<Double> supInt = () -> Math.random();
		
		Supplier<Car> carSup = Car::new;
		
		Supplier<String> generateStr = () -> "Newgen";
		
		Supplier<String> getUpdatedStr = () -> generateStr.get() + " in Java";
		System.out.println(getUpdatedStr.get());
		
//		Stream.generate(carSup).limit(5).forEach(car -> System.out.println( car.name));
//		
//		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//		
//		list.stream()
//		.filter(isEven)
//		.forEach(System.out::println);
		
//		if( 5>0 ) {
//			block of code
//		}
		
		Function<String,Integer> stringToInteger = String::length;
		
//		Function<Car, String> carObjToStr = car -> (car.name + " : " + car.thisCounter);
		Function<String, String> toUpper =  String::toUpperCase;
		Function<String, String> addUpdateStr = msg -> msg+="-Update";
		
//		Function<Car,String> carToUpdatedString = carObjToStr.andThen(addUpdateStr).andThen(toUpper);
		
//		int myInt = stringToInteger.apply("100");
//		System.out.println(myInt);
//		Stream.generate(carSup)
//		.limit(5)
//		.map(carToUpdatedString)
//		.forEach(System.out::println);
		
		
    }
	

}
