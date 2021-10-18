package com.patika.OtelAgency.business.abstracts;

import com.patika.OtelAgency.entities.Otel;

import java.util.List;

public interface OtelService {
    boolean add (Otel otel);
    List<Otel> getAll();
}
