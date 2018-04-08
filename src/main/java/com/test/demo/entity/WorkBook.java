package com.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 11:16 AM.
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "work_book")
public class WorkBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstName")
    String firstName;

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "lastName")
    String lastName;

//    @DateTimeFormat(pattern="YYYY-mm-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "age")
    private int age;

    @Column(name = "passportNumber")
    private String passportNumber;

    @OneToMany(mappedBy="workBook", cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("id")
    private Set<WorkPlace> workPlaces;

    public Set<WorkPlace> getWorkPlaces() {
        return workPlaces;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public WorkBook(String firstName, String lastName, Date dateOfBirth, int age, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    public WorkBook() {
    }
}
