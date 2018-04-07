package stackjava.com.sbrestful.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BaseController {

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
