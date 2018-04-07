package com.test.demo.service;

import com.test.demo.entity.WorkBook;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 12:50 PM.
 * To change this template use File | Settings | File Templates.
 */
public interface WorkBookService {
    void saveWorkBook(WorkBook workBook);
    List<WorkBook> getAllWorkerBook();

    WorkBook getWorkBookById(Integer id);
    void updateWorkBook(WorkBook workBook);
}
