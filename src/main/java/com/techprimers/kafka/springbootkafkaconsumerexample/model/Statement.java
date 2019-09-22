package com.techprimers.kafka.springbootkafkaconsumerexample.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Class statement describe data information about dater state.
 * @Field id  - unique identifier
 * @Field date  - date fo measure
 * @Field daterType describe type of dater(for example:temperature)
 * @Field value describe parameter of state(for example:temperature)
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statement {
    @NotNull
    private Long id;
    private Date date;
    private String daterType;
    private Integer value;
}


