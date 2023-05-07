package com.developer.keystone.controller;

import com.developer.keystone.domain.Facility1Data;
import com.developer.keystone.entity.Resident;
import com.developer.keystone.entity.Facilities;
import com.developer.keystone.entity.FacilityData;
import com.developer.keystone.service.MyService;
import com.developer.keystone.service.impl.FacilityServiceImpl;
import com.developer.keystone.service.impl.ResidentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FacilityDataController {
    @Autowired
    private FacilityServiceImpl facilityServiceImpl;

    @Autowired
    private ResidentServiceImpl residentServiceImpl;

    @Autowired
    private MyService myService;

    @Value("${spring.datasource.url}")
    private String url;

    @GetMapping("/create")
    public ResponseEntity<String> createSnapshot() {
        myService.createSnapshot();
        return ResponseEntity.ok("Snapshot created successfully");
    }

    @GetMapping("/getAllData")
    public List<FacilityData> getAllFacilityData() {
        return facilityServiceImpl.getFacilityData();
    }

    @GetMapping("/getAllResidents")
    public List<Resident> getAllResidentData() {
        System.out.println("URLLLLLLLLLL: " + url);
        return residentServiceImpl.getAllResidents();
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

