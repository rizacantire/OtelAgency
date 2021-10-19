package com.patika.OtelAgency.business.concretes;

import com.patika.OtelAgency.business.abstracts.OtelTypeService;
import com.patika.OtelAgency.dataAccess.abstracts.OtelTypeDao;
import com.patika.OtelAgency.entities.OtelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OtelTypeManager implements OtelTypeService {

    @Autowired
    private OtelTypeDao otelTypeDao;

    public OtelTypeManager(OtelTypeDao otelTypeDao) {
        this.otelTypeDao = otelTypeDao;
    }


    @Override
    public boolean add(OtelType otelType) {

                  this.otelTypeDao.save(otelType);
            return true;
        }

    @Override
    public List<OtelType> getAll() {

        return this.otelTypeDao.findAll();
    }
}
