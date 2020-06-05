package com.example.demo.service;


import com.example.demo.bean.StudentBean;
import com.example.demo.entities.StudentRegistrationEntity;
import org.springframework.stereotype.Service;

@Service
public interface StudentServiceInterface {

    //register|add student
    void registerStudent(StudentRegistrationEntity bean);
    //checking login
    boolean checkLogin(StudentBean validStudent);




}
