package newgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apricots","Apple", "Banana", "Mango","Apple" );
		
		List<String> result = new ArrayList<String>();
//		
//		for( String element: list) {
//			if(element.startsWith("A")) {
//				result.add(element);
//			}
//		}
//		
//		for (String element: result) {
//			System.out.println(element);
//		}
		
		result = list.stream()
//		    .filter(fruit -> fruit.startsWith("A"))
		    .distinct()
		    .map(String::toUpperCase)
		    .sorted(Comparator.reverseOrder())
		    .skip(1)
		    .limit(3)
		    .collect(Collectors.toList());
		
		for(String el: result) {
			System.out.println(el);
		}
		
//		list2.stream()

	}

}
