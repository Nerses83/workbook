package com.test.demo.service.impl;

import com.test.demo.entity.WorkBook;
import com.test.demo.repository.WorkBookRepository;
import com.test.demo.service.WorkBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 12:51 PM.
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WorkBookServiceImpl implements WorkBookService{


    WorkBookRepository workBookRepository;
    @Autowired
    public void setWorkBookRepository(WorkBookRepository workBookRepository) {
        this.workBookRepository = workBookRepository;
    }



    //    @Autowired


    @Override
    public void saveWorkBook(WorkBook workBook) {
        workBookRepository.save(workBook);


    }

    @Override
    public List<WorkBook> getAllWorkerBook() {
        return workBookRepository.findAll();
    }

    @Override
    public WorkBook getWorkBookById(Integer id) {
        return workBookRepository.findOne(id);
    }

    @Override
    public void updateWorkBook(WorkBook workBook) {
        workBookRepository.save(workBook);
    }

    @Override
    public void deleteWorkBook(Integer id) {
        workBookRepository.delete(id);
    }
}
