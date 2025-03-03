package newgen;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArrayLists {
	
	protected int numberOfIterations = 0;
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
		
		ArrayList<Integer> mergedList = mergeSortedLists(list1,list2);
		
		System.out.println("MergedList : " + mergedList);
	}

	private static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> mergedList = new ArrayList<>();
		
		int i=0;
		int j=0;
		
		while (i < list1.size() && j < list2.size()) {
			
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
		
		// Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
		return mergedList;
	}

}
