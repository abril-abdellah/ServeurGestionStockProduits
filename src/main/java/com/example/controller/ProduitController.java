package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Produit;
import com.example.service.ProduitMockService;

@RestController
@CrossOrigin
@RequestMapping
public class ProduitController {
	@Autowired
	ProduitMockService produitMockService;
	
	@GetMapping("/produits")
	public List<Produit> getProduits() {
		return produitMockService.getProduits();
	}
	
	@PostMapping("/produits")
	public void addProduit(@RequestBody Produit produit) {
		produitMockService.addProduit(produit);
	}
	@PutMapping("/produits")
	public void updateProduit(@RequestBody Produit produit) {
		produitMockService.updateProduit(produit);
	}
	@DeleteMapping(path = "/produits/{ref}")
	public void deleteProduit(@PathVariable String ref) {
		produitMockService.deleteProduit(ref);
	}
}
