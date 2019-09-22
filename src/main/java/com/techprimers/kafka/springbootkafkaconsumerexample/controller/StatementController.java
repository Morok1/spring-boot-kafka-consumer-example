package com.techprimers.kafka.springbootkafkaconsumerexample.controller;

import com.techprimers.kafka.springbootkafkaconsumerexample.StatementServiceImpl;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.DaterType;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * StatementCointroller describe endpoints for getting data according criteria.
 * @Field statementService
 */

@RestController
public class StatementController {
    @Autowired
    private StatementServiceImpl statementService;

    /**
     * Provide all statements from database.
     */
    @GetMapping("/all_statements")
    public List<Statement> getAll(){
        return statementService.getAll();
    }

    /**
     * Getting statements between  start_date and end_date.
     * @param time_start start of time interval
     * @param time_end end of time interval
     */
    @GetMapping("/date")
    public List<Statement> getDate(@RequestParam("time_start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date time_start,
                        @RequestParam("time_end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date time_end ){
        List<Statement>  statements = statementService.getAllStatementsByTimePeriod(time_start, time_end);

        return statements;
    }

    /**
     * Getting all statement by dater for all time.
     */
    @GetMapping("/daters")
    public Map<DaterType, Double> getAllStatementByTimePeriod(){
        return statementService.getAllStatementByTimePeriod();
    }
}
