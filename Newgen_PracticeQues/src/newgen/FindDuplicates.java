package newgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
	
	public static void main (String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,1,2,1,1,2,2,5,6));
		
		Set<Integer> duplicateSet = findDuplicates(list);
		
		System.out.println(duplicateSet);
	}

	private static Set<Integer> findDuplicates(ArrayList<Integer> list) {
		Set<Integer> duplicateSet = new HashSet<>();
		Set<Integer> uniqueSet = new HashSet<>();
		
		for(int num : list) {
			if(!uniqueSet.add(num)) {
				duplicateSet.add(num);
			}
		}
		
		
		return duplicateSet;
	}

}


