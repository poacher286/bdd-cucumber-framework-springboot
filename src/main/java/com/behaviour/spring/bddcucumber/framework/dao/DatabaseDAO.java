package com.behaviour.spring.bddcucumber.framework.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DatabaseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getDataFromDB(String sqlQuery){
        return jdbcTemplate.queryForList(sqlQuery);
    }
}
