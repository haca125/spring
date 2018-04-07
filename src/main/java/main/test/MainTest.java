package main.test;

import org.springframework.web.util.UriComponentsBuilder;

import stackjava.com.sbrestful.entities.User;

public class MainTest {
	public static void main(String[] args) throws Exception {
		String buildURL = UriComponentsBuilder.fromPath("https://192.168.3.1/gitlab").pathSegment("123")
				.pathSegment("projectId.git").build().toString();
		System.out.println(buildURL);

		User user = new User(1235, "haca125", "hahien");
		System.out.println(Util.toString(user));
	}
}
