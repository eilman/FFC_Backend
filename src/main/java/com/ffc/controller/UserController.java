package com.ffc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ffc.entity.Users;
import com.ffc.request.LoginRequest;
import com.ffc.service.UserService;

@RestController
@RequestMapping("/ffc")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getUser/{userId}")
	public Users getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
    private Long isValidLogin(@RequestBody LoginRequest loginRequest) {
    	Users authUser = null;
    	List<Users> userList = userService.getAllUsers();
    	for(Users user : userList) {
    		if(user.getUsername().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword()) ) {
    			authUser = user;
    		}
    	}
        return authUser.getUserId();
    }
	
	
	
/*
 * JWT Token üreterek bunun üzerinden login işlemini gerçekleştirmeye çalışırken fazlaca methodun (setSigningKey gibi) deprecated uyarısı ile karşılaşıldı. 
 * Deprecated methodların doğru çalışan alternatiflerini bulmak çok zaman almaya başlayınca database username-password check edildi. 
*/
	
/*
	@PostMapping("/auth")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		if (isValidLogin(loginRequest)) {
			String jwtToken = generateJwtToken(loginRequest.getUsername());
			return ResponseEntity.ok(new JwtResponse(jwtToken));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}


	private boolean isValidLogin(LoginRequest loginRequest) {
		boolean isValid = false;
		List<Users> userList = userService.getAllUsers();
		for(Users user : userList) {
			if(user.getUsername().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword()) ) {
				isValid = true;
			}
		}
	    return isValid;
	}
	
	public static String generateJwtToken(String username) {
	    Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	    Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
	
	    // JWT token oluşturma işlemi
	    String jwtToken = Jwts.builder()
	    		.claim("sub", username)
	            .claim("exp", expirationDate.getTime())
	            .signWith(key)
	            .compact();
	    return jwtToken;
	}
	
	
	public static Jws<Claims> parseJwtToken(String token) {
	    Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // Anahtar oluşturma
	    return Jwts.parser()
	            .setSigningKey(key)
	            .build()
	            .parseClaimsJws(token);
	}
*/

}
