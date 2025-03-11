package newgen;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		
		PriorityQueue<Task> taskQueue = new PriorityQueue<>();
		
		taskQueue.add( new Task("Fix bug", 2));
		taskQueue.add( new Task("Code Review", 3));
		taskQueue.add( new Task("Deploy App", 1));
		taskQueue.add( new Task("Write Documentation", 4));
		taskQueue.add( new Task("Work on updating sprint", 4));
		taskQueue.add( new Task("Deploy 2nd App", 1));
		
		System.out.println("Tasks in queue: " + taskQueue);
		
		while(!taskQueue.isEmpty()) {
			System.out.println("Processing: " + taskQueue.poll());
		}
		
	}
	
	public static class Task implements Comparable<Task>{

		private int priority;
		private String name;
		
		public Task(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}
		
		public String getName() {
			return name;
		}
		
		public int getPriority() {
			return priority;
		}
		
		@Override 
		public String toString() {
			return "Task{name='" + name + "', priority=" + priority + "}";
		}

		@Override
		public int compareTo(Task other) {
//			return Integer.compare(this.priority, other.priority);
			if (this.priority < other.priority) {
				return -1;
			}
			return 1;
		}
		
		
	}

}
