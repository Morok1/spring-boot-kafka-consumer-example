package com.techprimers.kafka.springbootkafkaconsumerexample.rawmapper;


import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementRowMapper implements RowMapper<Statement> {
    @Override
    public Statement mapRow(ResultSet rs, int i) throws SQLException {
        final Statement statement = new Statement();

        statement.setId((long) rs.getInt("id"));
        statement.setDate(rs.getDate("date_value"));
        statement.setDaterType(rs.getString("dater"));
        statement.setValue(rs.getInt("value"));

        return statement;
    }
}
