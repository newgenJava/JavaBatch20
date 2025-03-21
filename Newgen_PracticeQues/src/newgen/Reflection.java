package newgen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Reflection {

	public static void main(String args[]) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

		Car ferrari = new Car("Ferrai f40");

		String ferrariClassName = ferrari.getClass().getName();
		System.out.println(ferrariClassName);

		Field[] ferrariFields_ = ferrari.getClass().getDeclaredFields();
//		System.out.println(ferrariFields_.length);
		System.out.println(ferrari.getName());

		Field nameField = ferrari.getClass().getDeclaredField("name");
		nameField.set(ferrari, "ferrari2");
		System.out.println(ferrari.getName());

		Method method = ferrari.getClass().getDeclaredMethod("getName");
		method.setAccessible(true);
		System.out.println(method.invoke(ferrari));
		
		Car obj = ferrari.getClass().getConstructor().newInstance();
		System.out.println(obj.name);
//
//		for (Field field : ferrariFields_) {
//			if (field.getName().equalsIgnoreCase("counter")) {
//
//				field.setAccessible(true);
//				System.out.println(field.getName() + " " + field.getInt(ferrari));
//			}
//		}
	}

//		
//		Method[] ferrariFields = ferrari.getClass().getDeclaredMethods();
//		System.out.println(ferrariFields.length);
//		
//		for(Method field : ferrariFields) {
//			System.out.println(field.getName());
//		}

////	
//	private void myFunc(List<? extends Car> list) {
//
//		Object obj = list.get(0);
//		obj.getClass();
//
//	}
}
