package newgen;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Integer, String> employeeMap = new HashMap<>();
		employeeMap.put(101, "Alice");
		employeeMap.put(102, "Bob");
		employeeMap.put(103, "Charlie");
		employeeMap.put(104, "David");
		employeeMap.put(105, "Existing");
		
		System.out.println(employeeMap);
		
		System.out.println("Employee with ID 102 : " + employeeMap.get(102));
		
		if(employeeMap.containsKey(105)) {
			System.out.println("Employee with ID 105 exists");
		} else {
			System.out.println("Employee wth ID 105 does not exist");
		}
		
		for( Entry<Integer, String> entry : employeeMap.entrySet()) {
			System.out.println("ID : " + entry.getKey() + ", Name: " + entry.getValue());
		}
		System.out.println("\n");
		
		employeeMap.remove(105);
		
		for( Integer keyValue : employeeMap.keySet() ) {
			System.out.println("ID : " + keyValue + ", Name: " + employeeMap.get(keyValue));
		}
	}

}
