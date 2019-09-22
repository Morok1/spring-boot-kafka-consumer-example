package com.techprimers.kafka.springbootkafkaconsumerexample.dao;

import com.techprimers.kafka.springbootkafkaconsumerexample.config.SpringJdbcConfig;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import com.techprimers.kafka.springbootkafkaconsumerexample.rawmapper.StatementRowMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringJdbcConfig.class }, loader = AnnotationConfigContextLoader.class)
public class StatementDaoImplTest {
    @Autowired
    private StatementDaoImpl statementDao;


    private List<Statement> statementsExpected;

    @Before
    public void setUp() throws Exception {
        statementsExpected = asList(new Statement(1L, null, "ENGINE", 1));
    }

    @Test
    public void save() {
    }

    @Test
    public void getAllStatementsByTimePeriod() {
    }

    @Test
    public void getAllStatementsByType() {
    }

    @Test
    public void getAverageOfDateType() {
    }

    @Test
    public void getAll() {
        List<Statement> statementsActual = statementDao.getAll();
        assertEquals(statementsActual,
                statementsExpected);
    }
}