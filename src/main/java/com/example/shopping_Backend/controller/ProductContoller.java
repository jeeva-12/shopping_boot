package com.nest.Shoppingcart_backend.controller;

import com.nest.Shoppingcart_backend.dao.ProductDao;
import com.nest.Shoppingcart_backend.model.Products;
import com.nest.Shoppingcart_backend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class ProductController {
    @Autowired
    private ProductDao dao;
    @CrossOrigin(origins="*")
    @PostMapping(path ="/add",consumes ="application/json",produces = "application/json")
    public Map<String,String> AddProduct(@RequestBody Products p){
        System.out.println(p.getName().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getCategory().toString());
        System.out.println(p.getDescription().toString());
        System.out.println(p.getPrice());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/viewall")
    public List<Products> ViewAllProduct(){
        return (List<Products>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes ="application/json",produces ="application/json")
    public List<Products> SearchProducts(@RequestBody Products p)
    {
        String name=p.getName().toString();
        System.out.println(name);
        return (List<Products>) dao.SearchProducts(p.getName());
    }
}