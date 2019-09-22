package com.techprimers.kafka.springbootkafkaconsumerexample.dao;

import com.techprimers.kafka.springbootkafkaconsumerexample.config.SpringJdbcConfig;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.DaterType;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringJdbcConfig.class }, loader = AnnotationConfigContextLoader.class)
public class StatementDaoImplTest {
    @Autowired
    private StatementDaoImpl statementDao;

    List<Statement> statementsExpected;
    Map<DaterType, Double> daterTypeDoubleMapExpected;

    @Before
    public void setUp()  {
        statementsExpected = asList(new Statement(1L, null, "ENGINE", 1));
        daterTypeDoubleMapExpected =  new HashMap<>();
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
//        Map<DaterType, Double> daterTypeDoubleMapActual = statementDao.getAverageOfDateType();
//        assertEquals(daterTypeDoubleMapExpected, daterTypeDoubleMapActual);
    }

    @Test
    public void getAll() {
        List<Statement> statementsActual = statementDao.getAll();
        assertEquals(statementsActual,
                statementsExpected);
    }
}