package com.git.zxxxd.service;

import com.git.zxxxd.dao.PatientMapper;
import com.git.zxxxd.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public List selectAll(){
        return patientMapper.selectAll();
    }

    public void insert(){
        Patient p=new Patient();
        p.setPatientId("zxd123");
        p.setName("测试");
        patientMapper.insert(p);
    }
    public void delete(){
        patientMapper.delete("zxd123");
    }
}
