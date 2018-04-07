package stackjava.com.sbrestful.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import stackjava.com.sbrestful.entities.User;

@RestController
@RequestMapping("/rest")
public class UserRestController extends BaseController {
	
	@Autowired
	HttpServletRequest request;
	
	 public static HashMap<Integer, User> mapUser = new HashMap<Integer, User>();
	  static {
	    mapUser.put(1, new User(1, "kai", "123456"));
	    mapUser.put(2, new User(2, "admin", "admin1234"));
	    mapUser.put(3, new User(3, "sena", "123456"));
	    mapUser.put(4, new User(4, "peter", "1234"));
	  }
	  
	  /* ---------------- GET ALL USER ------------------------ */
	  @RequestMapping(value = "/users", method = RequestMethod.GET)
	  public ResponseEntity<List<User>> getAllUser() {
	    List<User> listUser = new ArrayList<User>(mapUser.values());
	    System.out.println(request.getServletPath());
	    System.out.println(request.getRequestURI());
	    return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	  }
	  
	  /* ---------------- GET USER BY ID ------------------------ */
	  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<Object> getUserById(@PathVariable int id) {
	    User user = mapUser.get(id);
	    if (user != null) {
	      return new ResponseEntity<Object>(user, HttpStatus.OK);
	    } else {
	    	throw new EntityNotFoundException(id + ": Not Found User");
	    }
	  }
	  
	  /* ---------------- CREATE NEW USER ------------------------ */
	  @RequestMapping(value = "/users", method = RequestMethod.POST)
	  public ResponseEntity<String> createUser(@RequestBody User user) {
	    if (mapUser.containsKey(user.getId())) {
	      return new ResponseEntity<String>("User Already Exist!", HttpStatus.CONFLICT);
	    }
	    mapUser.put(user.getId(), user);
	    return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
	  }
	  
	  /* ---------------- DELETE USER ------------------------ */
	  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	  public ResponseEntity<String> deleteUserById(@PathVariable int id) {
	    User user = mapUser.get(id);
	    if (user == null) {
	      return new ResponseEntity<String>("Not Found User", HttpStatus.OK);
	    }
	    
	    mapUser.remove(id);
	    return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	  }
	  
	  /* ---------------- UPDATE USER ------------------------ */
	  @RequestMapping(value = "/users", method = RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@RequestBody User user) {
	    User oldUser = mapUser.get(user.getId());
	    if (oldUser == null) {
	      return new ResponseEntity<String>("Not Found User", HttpStatus.NO_CONTENT);
	    }
	    
	    // replace old user by new user.
	    mapUser.put(user.getId(), user);
	    return new ResponseEntity<String>("Updated!", HttpStatus.OK);
	  }
	  
}
