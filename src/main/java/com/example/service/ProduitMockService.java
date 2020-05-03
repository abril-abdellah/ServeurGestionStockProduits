package com.example.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Produit;

@Service
public class ProduitMockService implements IProduitService{
	
	
	private List<Produit> produits;
	public ProduitMockService() {
		produits =  new ArrayList<>();
		produits.add(new Produit("Telephone", 86, new BigDecimal("1024.66")));
		produits.add(new Produit("Laptop", 37, new BigDecimal("1700.99")));
		produits.add(new Produit("Television", 37, new BigDecimal("1700.99")));

	}

	@Override
	public List<Produit> getProduits() {
		return this.produits;
	}

	@Override
	public void addProduit(Produit produit) {
		this.produits.add(produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		produits.removeIf(p -> {
			 return p.getRef().equals(produit.getRef());
		});
		produits.add(produit);
	}

	@Override
	public void deleteProduit(String ref) {
		produits.removeIf(produit-> produit.getRef().equals(ref));
	}
	
}
