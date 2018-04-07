package stackjava.com.sbrestful.entities;

import main.test.Util;

public class Group {
	private String name;
	private String id;

	public Group(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return Util.toString(this);
	}
}
