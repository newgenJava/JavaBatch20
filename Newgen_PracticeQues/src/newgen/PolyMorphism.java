package newgen;



class Parent {
	
//	public static String name = "";
    void show() {
        System.out.println("This is the Parent class " );
    }
    void parentShow() {
    	System.out.println("This is child method");
    }
}

class Child extends Parent {
	@Override
    void show() {  // Overriding the parent class method
        System.out.println("This is the Child class");
    }
    void childMethod() {
        System.out.println("Child-specific method");
    }
    void childShow() {
    	System.out.println("This is child method");
    }
}


public class PolyMorphism {
	
	public static void main(String[] args ) {
		Parent parentObj = new Parent();
		Parent childObj = new Child();
		Child childObj2 = new Child();
		
		//Upcasting
//		Parent childObj = new Child();
//		childObj.parentShow();
//		childObj.show();
//		
//		
		Parent obj2 = new Child();
		
		if (obj2 instanceof Child) {
		    Child childObj3 = (Child) obj2;
		    childObj3.childShow();  // ✅ Safe downcasting
		}


//		parentObj.show();
//		childObj.show();
//		childObj2.show();
		
		Parent obj = new Child(); // Upcasting
        obj.show();  // Output: Method in Child (Runtime Polymorphism)

        // Downcasting
//        Child childObj = (Child) obj;
//        childObj.childMethod();  // ✅ Output: Child-specific method
//		
	}

}
