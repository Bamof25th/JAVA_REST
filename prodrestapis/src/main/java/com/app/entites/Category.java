package com.app.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true) //, exclude = "p_list"
public class Category extends BaseEntity {
	@Column(name = "c_name", unique = true, length = 30)
	private String name;
	@Column(name = "c_description", length = 200)
	private String desc;
	// @OneToMany(mappedBy = "myCategory")
	// private List<Product> p_list = new ArrayList<>();

	public Category(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

}
