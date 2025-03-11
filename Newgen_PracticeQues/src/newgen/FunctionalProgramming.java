package newgen;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgramming {
	public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));  // true
        System.out.println(isEven.test(15));  // false
        
        Consumer<String> printer = message -> {
        	message = message.toUpperCase();
        	System.out.println(message);
        };
        printer.accept("Hello Consumer!");
        
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        System.out.println(randomNumber.get());
        
        
    }

}
