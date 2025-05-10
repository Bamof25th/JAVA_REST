package com.cdac.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass // below class will NOT have any table generation, sub class entities will
					// inherit these common members
@Getter
@Setter
@ToString
public class BaseEntity {
	@Id // mandatory , PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// for auditing purpose - can maintain creation n updation date|time|timestamp
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDate createdOn;
	@UpdateTimestamp
	@Column(name = "last_updated")
	private LocalDateTime lastUpdatedOn;
}
