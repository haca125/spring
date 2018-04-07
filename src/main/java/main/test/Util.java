package main.test;

import java.lang.reflect.Field;

public class Util {
	public static String toString(Object model) {
		StringBuilder result = new StringBuilder();
		result.append("{");
		// determine fields declared in this class
		Field[] fields = model.getClass().getDeclaredFields();
		// print field names paired with their values
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				result.append(field.getName()).append("=").append(field.get(model)).append(", ");
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
		}
		result.append("}");
		return result.toString().replace(", }", "}");
	}
}
