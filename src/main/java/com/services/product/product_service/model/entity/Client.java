package com.services.product.product_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;


    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean status;

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = false;
        }
    }
}
