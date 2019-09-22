package com.techprimers.kafka.springbootkafkaconsumerexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum daterType describe type dater.
 * @Field description reflect more concrete information about dater.
 */

@Getter
@AllArgsConstructor
public enum DaterType {
    ENGINE("ENGINE"),
    DOOR("DOOR"),
    WHEEL("WHEEL");

    private String description;
}
