package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
}
