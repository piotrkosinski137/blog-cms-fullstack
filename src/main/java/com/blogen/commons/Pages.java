package com.blogen.commons;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pages {

    private Pages() {
    }

    public static <ElementNewT, ElementT> PageDTO<ElementNewT> mapContent(
            Page<ElementT> page,
            Function<ElementT, ElementNewT> mapper) {

        Collection<ElementNewT> mappedContent = page.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList());

        return new PageDTO<>(page.getTotalPages(), page.getTotalElements(), mappedContent);
    }
}
