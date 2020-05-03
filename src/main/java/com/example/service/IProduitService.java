package com.example.service;

import java.util.List;

import com.example.entity.Produit;

public interface IProduitService {
	List<Produit> getProduits();
	void addProduit(Produit produit);
	void updateProduit(Produit produit);
	void deleteProduit(String ref);
}
