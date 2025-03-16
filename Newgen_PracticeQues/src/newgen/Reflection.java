package newgen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Reflection {

	public static void main(String args[]) {
		Car ferrari = new Car("Ferrai f40");
		
		String ferrariClassName = ferrari.getClass().getName();
		
		System.out.println(ferrariClassName);
		
		Field[] ferrariFields_ = ferrari.getClass().getDeclaredFields();
		System.out.println(ferrariFields_.length);
		
		for(Field field : ferrariFields_) {
			System.out.println(field.getName());
		}
		
		Method[] ferrariFields = ferrari.getClass().getDeclaredMethods();
		System.out.println(ferrariFields.length);
		
		for(Method field : ferrariFields) {
			System.out.println(field.getName());
		}
		
//		List<Field> ferrariFieldList = Arrays.asList(ferrariFields);
//		
//		ferrariFieldList.stream()
//		.forEach(n -> System.out.println(n.getName()));
		 	
		
//		carFieldList.stream().
		
	}
}
