package com.patika.OtelAgency.dataAccess.abstracts;

import com.patika.OtelAgency.entities.OtelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtelTypeDao extends JpaRepository<OtelType,Integer> {

}
