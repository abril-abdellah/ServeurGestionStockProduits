package com.example.service;

import java.util.List;

import com.example.entity.Produit;
import com.example.entity.User;

public interface IUserService {
	List<User> getUsres();
	public void ajouterUser(User user);
	public void modifierUser(User user);
	public void supprimerUser(Long id);
}
