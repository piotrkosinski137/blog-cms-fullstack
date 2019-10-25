package com.blogen.categories.controller;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CategoryMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private CategoryMapper() {
    }

    public static ModelMapper initialize() {
        mapper.addConverter(convertDateToString);
        return mapper;
    }

    private static Converter<LocalDate, String> convertDateToString =
            new AbstractConverter<LocalDate, String>() {
                protected String convert(LocalDate date) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    return date.format(formatter);
                }
            };
}
