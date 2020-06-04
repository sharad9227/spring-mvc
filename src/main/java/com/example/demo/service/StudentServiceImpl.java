package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entities.StudentRegistrationEntity;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service


public class StudentServiceImpl implements StudentServiceInterface {

    private  StudentDao dao;




    @Override
    @Transactional
    public void registerStudent(StudentRegistrationEntity student) {
        this.dao.registerStudent(student);
    }




    @Override

    public boolean checkLogin (StudentRegistrationEntity student) {
        return this.dao.checkLogin(student);
    }


}
