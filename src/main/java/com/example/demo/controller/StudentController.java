package com.example.demo.controller;

import com.example.demo.bean.StudentBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.example.demo.dao.StudentDaoInterface;
import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.StudentRegistrationEntity;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class StudentController

{
    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);





    @Autowired
    private StudentServiceImpl studentServiceInterface;



    @Qualifier("clientService")
    public void setStudentService(StudentServiceImpl studentServiceInterface){
        this.studentServiceInterface=studentServiceInterface;
    }


    @RequestMapping(value = "/getStudents",method = RequestMethod.GET)
    public ResponseEntity<List<StudentEntity>> getStudents() {
        StudentDao dao = new StudentDao();
        List<StudentEntity> list=dao.getStudentDetails();

        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity registerStudent(@RequestBody StudentRegistrationEntity requestUserDetails){


        StudentRegistrationEntity stud =new StudentRegistrationEntity();
        stud.setPassword(requestUserDetails.getPassword());
        stud.setEmailId(requestUserDetails.getEmailId());
        stud.setFullName(requestUserDetails.getFullName());


        studentServiceInterface.registerStudent(stud);
        return new ResponseEntity(HttpStatus.OK);




    }




}
