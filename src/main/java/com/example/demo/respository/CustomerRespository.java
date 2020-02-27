package com.example.demo.respository;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRespository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll(){
        return jdbcTemplate.query("SELECT id,name,email From customers",
                (rs, rowNum) -> new Customer(rs.getInt("id"),
                rs.getString("name"), rs.getString("email")));
    }
}
