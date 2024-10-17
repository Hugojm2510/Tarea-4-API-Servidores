package com.vedruna.apitabla.persistance.controllers;

import com.vedruna.apitabla.persistance.models.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// para ver que ruta vamos a utilizar
import org.springframework.web.bind.annotation.RequestMapping;

// para utilizar RestController
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.apitabla.services.ProductServiceI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductServiceI productMngmnt;

    @GetMapping
    public List<Product> getAllProducts() {
        return productMngmnt.showAllProducts();
    }

    @GetMapping("/name/{productName}")                                          // la ruta con la que vamos a utilizar esta funcion
    public Product getMethodName(@PathVariable String productName) {            // si dice Product cannot be resolve es por el import de arriba 
        return productMngmnt.showProductByProductName(productName);
    }
    
    @GetMapping("/price/{productPrice}")
    public Product getMethodName(@PathVariable Double productPrice) {
        return productMngmnt.showProductByProductPrice(productPrice);
    }


    @PostMapping("/insert")
    public String postProduct(@RequestBody Product product) {        
        productMngmnt.saveProduct(product);
        return "Product saved";
    }


    @PutMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @RequestBody Product product) {
        productMngmnt.updateProduct(id, product);        
        return "Product modified";
    }


    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productMngmnt.deleteProduct(id);
        return "Product deleted";
    }    
    
}

/* 
aqui hemos puesto las distintas acciones que vamos a poder realizar en la api, introduciendo funciones que hemos declarado antes,
con las rutas que vamos a tener que poner para poder utilizar dichas acciones:

    - Recoger (GET)
    - Guardar (POST)
    - Editar (PUT)
    - Borrar (DELETE)
*/