package com.test.demo.controllers;

import com.test.demo.entity.WorkBook;
import com.test.demo.service.WorkBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 2:09 PM.
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class WorkBookRestController {

    @Autowired
    WorkBookService workBookService;

    @GetMapping("/rest/books")
    public List<WorkBook> list(Model model) {
        List<WorkBook> workBookList = workBookService.getAllWorkerBook();
        return workBookList;
    }
}
