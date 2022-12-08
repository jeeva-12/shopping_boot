package com.nest.Shoppingcart_backend.dao;

import com.nest.Shoppingcart_backend.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersDao extends CrudRepository<Users,Integer> {
    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phno` FROM `users` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<Users> SearchUser(@Param("email") String name,@Param("password") String password);
}
