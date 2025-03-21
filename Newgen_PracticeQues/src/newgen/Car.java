package newgen;

public class Car {
	public String name;
	private static int counter = 1;
	
	int thisCounter;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Car.counter = counter;
	}
	public int getThisCounter() {
		return thisCounter;
	}
	public void setThisCounter(int thisCounter) {
		this.thisCounter = thisCounter;
	}
	public Car(String name) {
		super();
		this.name = name;
	}
	public Car() {
		this.name = "Car-"+counter;
		this.thisCounter = counter++;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", thisCounter=" + thisCounter + "]";
	}
}