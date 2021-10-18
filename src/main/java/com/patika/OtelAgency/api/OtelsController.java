package com.patika.OtelAgency.api;

import com.patika.OtelAgency.business.abstracts.OtelService;
import com.patika.OtelAgency.entities.Otel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OtelsController {

    private OtelService otelService;

    public OtelsController(OtelService otelService) {
        this.otelService = otelService;
    }

    @GetMapping("getall")
    public List<Otel> getAll(){
        return this.otelService.getAll();
    }

    @PostMapping("add")
    public void add(@RequestBody Otel otel){
        this.otelService.add(otel);
    }

}
