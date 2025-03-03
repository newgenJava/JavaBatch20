package newgen;

import java.util.LinkedList;

public class LinkeddList {
		public static void main(String args[]) {
			
			LinkedList<Integer> list = new LinkedList<>();
			
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			
//			System.out.println(list);
			
			list.remove(1);
//			System.out.println(list);
			
			list.add(1, 99);
//			System.out.println(list);
			
			LinkedList<Integer> list2 = new LinkedList<>();
			list2.add(1);
			list2.add(2);
			list2.add(3);
			list2.add(4);
//			System.out.println("list2 : " + list2);
			
			list.addAll(list2);
//			System.out.println("list : " + list);
//			
//			System.out.println("Peek of list : " + list.peek());
//			System.out.println("PeekLast of list : " + list.peekLast());
//			System.out.println("Pop of list : " + list.pop());
			
//			while(!list.isEmpty()) {
//				System.out.println("My Queue element : " + list.poll());
//			}
			
			list.clear();
			list.addLast(1);
			list.addLast(2);
			list.addFirst(3);
			System.out.println("list : " + list);
			
			
		}
}
