package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.service.ProduitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProduitController {
	
	@Autowired
	ProduitService produitService;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/api/produits")
	public List<Produit> getProduits() {
		return produitService.getProduits();
	}
	
	@PostMapping("/api/produits")
	public void addProduit(@RequestBody Produit produit) {
		produitService.addProduit(produit);
	}
	@PutMapping("/api/produits")
	public void updateProduit(@RequestBody Produit produit) {
		produitService.updateProduit(produit);
	}
	@DeleteMapping(path = "/api/produits/{id}")
	public void deleteProduit(@PathVariable Long id) {
		produitService.deleteProduit(id);
	}
}
