package com.example.demo.dao;
import com.example.demo.bean.StudentBean;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.StudentRegistrationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDaoInterface {





        //register|add student


        List<StudentEntity> getStudentDetails();

        void registerStudent(StudentRegistrationEntity studentReg);
        //checking login
        boolean checkLogin(StudentBean validStudent);



}
