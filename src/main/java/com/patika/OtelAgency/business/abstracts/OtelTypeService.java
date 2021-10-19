package com.patika.OtelAgency.business.abstracts;

import com.patika.OtelAgency.entities.OtelType;

import java.util.List;

public interface OtelTypeService {
    boolean add(OtelType otelType);
    List<OtelType> getAll();
}
