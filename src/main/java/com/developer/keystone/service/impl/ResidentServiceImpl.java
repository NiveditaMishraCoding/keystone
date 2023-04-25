package com.developer.keystone.service.impl;

import com.developer.keystone.domain.Resident;
import com.developer.keystone.entity.ResidentInFacility2;
import com.developer.keystone.repository.ResidentInFacility1Repository;
import com.developer.keystone.repository.ResidentInFacility2Repository;
import com.developer.keystone.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    private ResidentInFacility1Repository residentInFacility1Repository;

    @Autowired
    private ResidentInFacility2Repository residentInFacility2Repository;

    @Override
    public List<Resident> getAllResidents() {
        List<Resident> residents = new ArrayList<>();
        residents.addAll(getResidentInFacility1());
//        residents.addAll(getResidentInFacility2());
        return residents;
    }
    private List<Resident> getResidentInFacility1() {
        List<com.developer.keystone.entity.Resident> list = this.residentInFacility1Repository.findAll();
        List<Resident> residents = new ArrayList<>();
        for(com.developer.keystone.entity.Resident source : list){
            Resident resident = new Resident();
            resident.setFacilityId(1);
            resident.setPid(source.getPid());
            resident.setFirstName(source.getFirstName());
            resident.setLastName(source.getLastName());
            resident.setGender(source.getGender());
            resident.setAge(source.getAge());
            resident.setHasPet(source.getHasPet());
            resident.setPhoto(source.getPhoto());
            resident.setIsAmbulatory(source.getIsAmbulatory());
            resident.setIsAbleToCommunicate(source.getIsAbleToCommunicate());
            resident.setMedicalInformation(source.getMedicalInformation());
            resident.setIsFallRisk(source.getIsFallRisk());
            resident.setIsWanderRisk(source.getIsWanderRisk());
            resident.setIsElopementRisk(source.getIsElopementRisk());
            residents.add(resident);
        }
        return residents;
    }

    private List<Resident> getResidentInFacility2() {
        List<ResidentInFacility2> list = this.residentInFacility2Repository.findAll();
        List<Resident> residents = new ArrayList<>();
        for(ResidentInFacility2 source : list){
            Resident resident = new Resident();
            resident.setFacilityId(2);
            resident.setPid(source.getPid());
            resident.setFirstName(source.getFirstName());
            resident.setLastName(source.getLastName());
            resident.setGender(source.getGender());
            resident.setAge(source.getAge());
            resident.setHasPet(source.getHasPet());
            resident.setPhoto(source.getPhoto());
            resident.setIsAmbulatory(source.getIsAmbulatory());
            resident.setIsAbleToCommunicate(source.getIsAbleToCommunicate());
            resident.setMedicalInformation(source.getMedicalInformation());
            resident.setIsFallRisk(source.getIsFallRisk());
            resident.setIsWanderRisk(source.getIsWanderRisk());
            resident.setIsElopementRisk(source.getIsElopementRisk());
            residents.add(resident);
        }
        return residents;
    }
}
