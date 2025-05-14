package com.bam.users_vehicles.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "u_name", unique = true)
    private String uname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "contact_no", nullable = false, length = 13)
    private String contactNo;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;

    // Bi-directional relationship with Vehicle
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();

    // Helper method to establish a bi-directional association between User and
    // Vehicle
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle); // parent -> child
        vehicle.setUser(this); // child -> parent
    }

    // Helper method to de-link a bi-directional association between User and
    // Vehicle
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
        vehicle.setUser(null);
    }

    
}
