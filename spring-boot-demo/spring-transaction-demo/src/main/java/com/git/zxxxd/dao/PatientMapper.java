package com.git.zxxxd.dao;

import com.git.zxxxd.entity.Patient;

import java.util.List;

public interface PatientMapper {
    List<Patient> selectAll();
    void insert(Patient patient);
    void delete(String id);
}
