package com.patika.OtelAgency.dataAccess.abstracts;


import com.patika.OtelAgency.entities.Otel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtelDao extends JpaRepository<Otel,Integer> {
    Otel findAllByName(String name);
}
