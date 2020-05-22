package com.example.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> getUsres() {
		return userRepo.findAll();
	}

	@Override
	public void ajouterUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void modifierUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void supprimerUser(Long id) {
		userRepo.deleteById(id);
	}

	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
}
