package com.example.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ERole;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.request.EnregistrementUtilisateurRequest;
import com.example.entity.response.MessageResponse;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.UserDetailsImpl;
import com.example.service.UserService;

@RestController
public class UtilisateurController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserService userService;
	
	@PostMapping("/api/sinscrire")
	public ResponseEntity<?> registerUser(@Valid @RequestBody EnregistrementUtilisateurRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account with user role
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setActive(false);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/api/utilisateur")
	public ResponseEntity<?> modifierUser(@Valid @RequestBody EnregistrementUtilisateurRequest userToUpdate) throws Exception {
		if(!userRepository.existsByUsername(userToUpdate.getUsername())){
			return ResponseEntity.badRequest().body("This user doesn't exist");
		}
		User user = new User();
		user.setId(userRepository.findByUsername(userToUpdate.getUsername())
				.orElseThrow(()->new Exception("Error while getting password of user to updated"))
				.getId());
		user.setUsername(userToUpdate.getUsername());
		user.setEmail(userToUpdate.getEmail());
		user.setActive(userToUpdate.isActive());
		String pass = userRepository.findByUsername(userToUpdate.getUsername())
				.orElseThrow(()->new Exception("Error while getting password of user to updated"))
				.getPassword();
		user.setPassword(pass);
		Set<String> reqRoles = userToUpdate.getRole();
		Set<Role> roles = new HashSet<>();
		if(reqRoles == null || reqRoles.isEmpty()) {
			Role role = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(()->new Exception("role not found!"));
			roles.add(role);
		}
		else {
			reqRoles.forEach(r->{
				switch (r) {
				case "admin":
					Role roleA = new Role(ERole.ROLE_ADMIN);
					roles.add(roleA);
					break;
				default:
					Role roleU = new Role(ERole.ROLE_USER);
					roles.add(roleU);
				}
			});
		}
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(path = "/api/utilisateur/{id}")
	public void supprimerUser(@PathVariable Long id) {
		userService.supprimerUser(id);
	}
		
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/api/utilisateur")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
