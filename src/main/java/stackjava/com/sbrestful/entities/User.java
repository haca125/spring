package stackjava.com.sbrestful.entities;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import main.test.Util;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "password" })

public class User {
	private int id;
	private String username;
	private String password;
	private List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");
	private Map<String, String> mapTest = new HashMap<String, String>();
	private Group group;
	public User() {
		
	}

	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		mapTest.put("key1", "value1");
		mapTest.put("key2", "value2");
		mapTest.put("key3", "value3");
		group = new Group("123", "group1");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return Util.toString(this);
	}
}
