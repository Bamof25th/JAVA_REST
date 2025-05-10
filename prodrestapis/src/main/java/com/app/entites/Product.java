package com.app.entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//LOMBOK
@NoArgsConstructor
@Getter
@Setter

@Entity // means this is a POJO that going in the DB and
@Table(name = "products")

@ToString(callSuper = true)//, exclude = "myCategory"
public class Product extends BaseEntity {

	@Column(name = "p_name", length = 20, unique = true)
	private String name;

	@Column(name = "p_description", length = 200, nullable = false)
	private String description;

	@Column(name = "p_price")
	private Double price;

	@Column(name = "p_mfd")
	private LocalDate mfd;

	@Column(name = "p_available_quantity")
	private Integer availableQuantity;

	// @ManyToOne
	// @JoinColumn(name = "category_id")
	// private Category myCategory;

	public Product(String name, String description, Double price, LocalDate mfd, Integer availableQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.mfd = mfd;
		this.availableQuantity = availableQuantity;
	}
}
