package com.firstApp.person;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PersonRowMapper implements RowMapper<Person>{

    @Override
    @Nullable
    public Person mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getInt("age")
        );
        return person;
    }
    
}
