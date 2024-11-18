package com.udea.sagoa.dominio.user.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "profiles")
@Getter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "id_card", nullable = false, unique = true)
    private String idCard;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile() {}

}
