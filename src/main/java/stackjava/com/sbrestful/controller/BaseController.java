package stackjava.com.sbrestful.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import stackjava.com.sbrestful.entities.User;

@Controller
public class BaseController {

	@Autowired
	HttpServletRequest request;
	protected static HashMap<Integer, User> mapUser = new HashMap<Integer, User>();
	static {
		mapUser.put(1, new User(1, "kai", "123456"));
		mapUser.put(2, new User(2, "admin", "admin1234"));
		mapUser.put(3, new User(3, "sena", "123456"));
		mapUser.put(4, new User(4, "peter", "1234"));
	}

	protected String getPathAPI() {
		return request.getServletPath();
	}

	@RequestMapping("/")
	public String index() {
		return "templates/index";
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	public String handleEntityNotFoundException(EntityNotFoundException ex) {
		return ex.getMessage();
	}
}
