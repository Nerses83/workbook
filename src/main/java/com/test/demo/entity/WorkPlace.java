package com.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 11:16 AM.
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class WorkPlace {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "company")
    String company;

    @Column(name = "country")
    String country;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "isCurrent")
    private boolean isCurrent;

//    public int getWorkbook_id() {
//        return workbook_id;
//    }

//    public void setWorkbook_id(int workbook_id) {
//        this.workbook_id = workbook_id;
//    }
//
//    @Column(name = "workbook_id")
//    private int workbook_id;

    @ManyToOne
    @JoinColumn(name="workbook_id", nullable=false)
    @JsonBackReference
    private WorkBook workBook;

    public WorkBook getWorkBook() {
        return workBook;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setWorkBook(WorkBook workBook) {
        this.workBook = workBook;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public WorkPlace() {
    }

    public WorkPlace(String company, String country, Date startDate, Date endDate, boolean isCurrent) {
        this.company = company;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrent = isCurrent;
    }
}
