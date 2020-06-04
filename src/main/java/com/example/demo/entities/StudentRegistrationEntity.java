package com.example.demo.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "StudentRegistration", schema = "dbo", catalog = "master")
public class StudentRegistrationEntity {
    private int id;
    private String emailId;
    private String fullName;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email_id")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRegistrationEntity that = (StudentRegistrationEntity) o;
        return id == that.id &&
                Objects.equals(emailId, that.emailId) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailId, fullName, password);
    }
}
