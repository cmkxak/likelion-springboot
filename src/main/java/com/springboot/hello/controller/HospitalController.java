package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public String getHospital(@PathVariable int id) {
        Hospital hospital = hospitalDao.findById(id);

        return hospital.getHospitalName() + " " + hospital.getFullAddress() + " " + hospital.getRoadNameAddress() +
                " " + hospital.getHealthcareProviderCount() + " " + hospital.getTotalNumberOfBeds() + " " + hospital.getTotalAreaSize(); //폐업 여부는 아직 구현하지 않음
    }


}
