package com.blogen.commons;

import java.util.ArrayList;
import java.util.Collection;

public class PageDTO<ElementT> {
    private int totalPages;
    private long totalElements;
    Collection<ElementT> elements;

    public PageDTO(int totalPages, long totalElements, Collection<ElementT> elements) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.elements = elements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public Collection<ElementT> getElements() {
        return elements;
    }
}
