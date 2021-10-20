package com.patika.OtelAgency.business.abstracts;

import com.patika.OtelAgency.entities.Property;

import java.util.List;

public interface OtelPropertyService {
    List<Property> getAll();
}
