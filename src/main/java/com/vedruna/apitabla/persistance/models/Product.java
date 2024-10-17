package com.vedruna.apitabla.persistance.models;

// este es de implements
import java.io.Serializable;

// estos 3 son para el id, generar el valor id (porque se autoincrementa), columna (que vamos a coger)
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// estos son los 4 import para los primero 4 @
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;


@NoArgsConstructor
@Data
@Entity
@Table(name="products")
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private Float productPrice;

    // los nombres de private van escritos igual 

}