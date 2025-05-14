package com.bam.users_vehicles.entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity {
    @Column(name = "v_name")
    private String vName;

    @Column(name = "company")
    private Company company;

    @Column(name = "v_number", unique = true)
    private String vNumber;

    @Column(name = "v_type", nullable = false)
    private String vType;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;
}
