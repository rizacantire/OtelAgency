package com.patika.OtelAgency.dataAccess.abstracts;

import com.patika.OtelAgency.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtelPropertyDao extends JpaRepository<Property,Integer> {
}
