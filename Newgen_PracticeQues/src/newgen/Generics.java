package newgen;

import java.util.Arrays;
import java.util.List;

public class Generics {

	public static void main(String[] args) {
		Box<Integer> intBox = new Box<>();
		List<Double> dblList = Arrays.asList(2.2,3.5);
		List<Integer> intList = Arrays.asList(1,2,3,4);
		intBox.addList(dblList);
		intBox.addList(intList);
//		Box<String> strigBox = new Box<>();
//		Box<Double> dblBox = new Box<>();
		
//		Car[] intArray = {new Car(), new Car("ferrari"), new Car(), new Car("lambo")};
//        String[] strArray = {"A", "B", "C"};
//
//        Util.printArray(intArray); // Output: 1 2 3 4
//        Util.printArray(strArray); // Output: A B C
		

	}
}

class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " " +"\n");
        }
        System.out.println();
    }
}

class Box<T extends Number> {
    private T value;
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public void addList(List<? extends Number> mylist)
    {
    	for (Number num : mylist) {
            System.out.print(num + " ");
        }
    	System.out.println();
    }

    public T getValue() {
        return value;
    }
}