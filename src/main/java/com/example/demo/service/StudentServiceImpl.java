package com.example.demo.service;

import com.example.demo.bean.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entities.StudentRegistrationEntity;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentServiceInterface;
import org.springframework.stereotype.Service;


@Service


public class StudentServiceImpl implements StudentServiceInterface {
    @Autowired
    private  StudentDao dao;

    @Override

    public void registerStudent(StudentRegistrationEntity student) {
        this.dao.registerStudent(student);
    }




    @Override

    public boolean checkLogin (StudentBean student) {
        return this.dao.checkLogin(student);
    }


}
