package com.nest.Shoppingcart_backend.controller;

import com.nest.Shoppingcart_backend.dao.ProductDao;
import com.nest.Shoppingcart_backend.dao.UsersDao;
import com.nest.Shoppingcart_backend.model.Products;
import com.nest.Shoppingcart_backend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UsersDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addusers", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddUser(@RequestBody Users u) {
        System.out.println(u.getName().toString());
        System.out.println(u.getAddress().toString());
        System.out.println(u.getPhno().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getPassword().toString());
        dao.save(u);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/usersearch",consumes ="application/json",produces ="application/json")
    public List<Users> SearchUser(@RequestBody Users u)
    {
        String email=u.getEmail().toString();
        String password=u.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        return (List<Users>) dao.SearchUser(u.getEmail(),u.getPassword());
    }
}
