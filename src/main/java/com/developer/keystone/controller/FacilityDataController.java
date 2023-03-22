package com.developer.keystone.controller;

import com.developer.keystone.domain.Facility1Data;
import com.developer.keystone.entity.Facilities;
import com.developer.keystone.entity.FacilityData;
import com.developer.keystone.repository.FacilityDataRepository;
import com.developer.keystone.service.impl.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FacilityDataController {
    @Autowired
    private FacilityServiceImpl facilityServiceImpl;

    @GetMapping("/getAllData")
    public List<FacilityData> getAllFacilityData() {
        return facilityServiceImpl.getFacilityData();
    }

    @PutMapping("updatePatientRecord")
    public String updatePatient(@RequestBody Facility1Data data){
        return this.facilityServiceImpl.updatePatientInFacility(data);
    }

    @PutMapping("updateFacilityData")
    public String updateFacilitiesData(@RequestBody Facilities data){
        return this.facilityServiceImpl.updateFacilitiesData(data);
    }


}

