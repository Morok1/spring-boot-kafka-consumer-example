package com.techprimers.kafka.springbootkafkaconsumerexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techprimers.kafka.springbootkafkaconsumerexample.controller.StatementController;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.DaterType;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StatementController.class)
public class StatementControllerTest {
    @Autowired
    private MockMvc mvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String content;
    private Statement statement;

    @MockBean
    private StatementServiceImpl statementService;

    @Before
    public void setUp() throws JsonProcessingException {
        statement = Statement.builder().id(1L)
                .daterType(DaterType.ENGINE.getDescription())
                .value(1)
                .build();
        List<Statement> statements = Collections.singletonList(statement);
        content = objectMapper.writeValueAsString(statements);
    }

    @Test
    public void getAll() throws Exception {
        //before
        given(statementService.getAll()).willReturn(Collections.singletonList(statement));

        //act
        this.mvc.perform(get("/all_statements")
                .accept(MediaType.APPLICATION_JSON))

               //test
                .andExpect(status().isOk()).andExpect(content().json(content));


    }

    @Test
    @Ignore
    //TODO I should do
    public void getDate() throws Exception {
        //before
        given(statementService
                .getAllStatementsByTimePeriod(
                        any(Date.class),
                                any(Date.class)))
                .willReturn(Collections.singletonList(statement));
        //act
        this.mvc.perform(get("/date")
                .requestAttr("time_start", new Date(12))
                .requestAttr("time_end", new Date(13))
                .accept(MediaType.APPLICATION_JSON))

                //test
                .andExpect(status().isOk())
                .andExpect(content().json(content));

        }

    @Test
    public void getAllStatementByTimePeriod() {

    }
}