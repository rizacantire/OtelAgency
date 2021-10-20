package com.patika.OtelAgency.business.concretes;

import com.patika.OtelAgency.business.abstracts.OtelPropertyService;
import com.patika.OtelAgency.dataAccess.abstracts.OtelPropertyDao;
import com.patika.OtelAgency.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtelPropertyManager implements OtelPropertyService {

    @Autowired
    private OtelPropertyDao otelPropertyDao;

    public OtelPropertyManager(OtelPropertyDao otelPropertyDao) {
        this.otelPropertyDao = otelPropertyDao;
    }

    @Override
    public List<Property> getAll() {
        return this.otelPropertyDao.findAll();
    }
}
