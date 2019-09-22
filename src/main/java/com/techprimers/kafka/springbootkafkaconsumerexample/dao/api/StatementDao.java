package com.techprimers.kafka.springbootkafkaconsumerexample.dao.api;



import com.techprimers.kafka.springbootkafkaconsumerexample.model.DaterType;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatementDao {
    void save(LocalDate date, String dater, int value);
    List<Statement> getAllStatementsByTimePeriod(Date start, Date end);
    List<Statement> getAllStatementsByType(DaterType type);
    Map<DaterType, Double> getAverageOfDateType();
    List<Statement> getAll();

}
