package br.hkprogrammer.fullstack.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer amount;
	
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	

	public Product(Long id, String name, Integer amount, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.category = category;
	}
	
	
	
}
