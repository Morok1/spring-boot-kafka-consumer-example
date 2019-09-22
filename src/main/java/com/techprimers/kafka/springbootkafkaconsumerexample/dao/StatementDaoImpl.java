package com.techprimers.kafka.springbootkafkaconsumerexample.dao;

import com.techprimers.kafka.springbootkafkaconsumerexample.dao.api.StatementDao;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.DaterType;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import com.techprimers.kafka.springbootkafkaconsumerexample.rawmapper.StatementRowMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Dao service.
 * Provide some methods for data taking from database.
 */

@Service
@Log
public class StatementDaoImpl implements StatementDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * Method save measure information
     * @param date1 - date of measure
     * @param dater - type of dater
     * @param value1 - measure information
     */
    @Override
    public void save(LocalDate date1, String dater, int value1) {
        jdbcTemplate.update("INSERT INTO STATEMENT VALUES (null, ?, ?, ?)",  date1,dater,value1);
    }


    /**
     *
     */
    @Override
    public List<Statement> getAllStatementsByTimePeriod(Date start, Date endTime) {

        return jdbcTemplate.query("select * from STATEMENT where DATE_VALUE between '2019-01-10' and '2020-01-11'",
                new StatementRowMapper());
    }

    /**
     *
     */
    @Override
    public List<Statement> getAllStatementsByType(DaterType type) {
        List<Statement> statements = null;
        return statements;
    }

    /**
     *
     */
    @Override
    public Map<DaterType, Double> getAverageOfDateType() {
        Map<DaterType, Double> daterTypeDoubleMap =
                new HashMap<>();

        for (DaterType daterType: DaterType.values()) {
            Double averageDateType = jdbcTemplate.queryForObject("SELECT avg(value) FROM STATEMENT where dater="
                    + daterType.getDescription(), Double.class);

            daterTypeDoubleMap.put(daterType, averageDateType);

        }

        return daterTypeDoubleMap;
    }

    /**
     *
     */
    @Override
    public List<Statement> getAll() {
        return jdbcTemplate.query("select * from statement", new StatementRowMapper());

    }
}
