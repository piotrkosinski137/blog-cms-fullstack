package com.blogen.posts.controller;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {

    private static final ModelMapper mapper = new ModelMapper();

    private Mapper() {
    }

    public static ModelMapper initialize() {
        mapper.addConverter(convertDateToString);
        return mapper;
    }

    private static Converter<LocalDateTime, String> convertDateToString =
            new AbstractConverter<LocalDateTime, String>() {
                protected String convert(LocalDateTime date) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    return date.format(formatter);
                }
            };
}
