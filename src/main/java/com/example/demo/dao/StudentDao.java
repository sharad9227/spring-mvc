package com.example.demo.dao;




import com.example.demo.entities.StudentEntity;
import com.example.demo.entities.StudentRegistrationEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Repository
public  class StudentDao implements StudentDaoInterface{

    public static final Logger logger= LoggerFactory.getLogger(StudentDao.class);

    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    public List<StudentEntity> getStudentDetails()
    {

        StudentDao student =new StudentDao();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        List<StudentEntity> resultList=null;
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("from  StudentEntity e  ");
            //query.setParameter("IDone", ID1);
            resultList = query.getResultList();
            for (StudentEntity item : resultList) {
                System.out.println(item.getEmailId());
            }
            em.close();
        }
        finally {
            entityManagerFactory.close();
            return resultList;
        }


        //return resultList;
    }






    @Override
    public void registerStudent(StudentRegistrationEntity registerStudent)
    {

        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(registerStudent);
            logger.info("Person saved successfully, Person Details=" + registerStudent);
        }

        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }


    public boolean checkLogin(StudentRegistrationEntity validStudent) {
        return false;
    }









}
