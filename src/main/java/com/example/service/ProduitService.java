package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Produit;
import com.example.repository.ProduitRepository;

@Service
public class ProduitService implements IProduitService{
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public List<Produit> getProduits() {
		return produitRepository.findAll();
	}

	@Override
	public void addProduit(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}
	
}
