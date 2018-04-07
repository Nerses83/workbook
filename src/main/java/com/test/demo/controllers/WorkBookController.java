package com.test.demo.controllers;

import com.test.demo.entity.WorkBook;
import com.test.demo.service.WorkBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 2:09 PM.
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class WorkBookController {

    @Autowired
    WorkBookService workBookService;

    @GetMapping("/")
    public String list(Model model) {
        List<WorkBook> workBookList = workBookService.getAllWorkerBook();
        model.addAttribute("workBookList", workBookList);
        return "index";
    }


//    @GetMapping("/add")
//    public String add() {
//        WorkBook workBook = new WorkBook("nn", "aa", new Date(), 24, "AE 154121");
//        workBookService.saveWorkBook(workBook);
//        List<WorkBook> workBookList = workBookService.getAllWorkerBook();
//        return "index";
//    }

    @GetMapping("/add")
    public String newWorkBook() {
        return "operations/new";
    }


    @PostMapping("/save")
    public String saveNote(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String passportNumber, @RequestParam String dateOfBirth) {
        Date date = convertStringToDate(dateOfBirth);
        int h =0;

        WorkBook workBook = new WorkBook(firstName, lastName, date, age, passportNumber);
        workBookService.saveWorkBook(workBook);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        WorkBook workBook = workBookService.getWorkBookById(id);
        model.addAttribute("workBook", workBook);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String passportNumber, @RequestParam String dateOfBirth) {
        WorkBook workBook = new WorkBook(firstName, lastName, convertStringToDate(dateOfBirth), age, passportNumber);

        workBook.setId(id);
        workBookService.updateWorkBook(workBook);
        return "redirect:/";
    }


    public Date convertStringToDate(String dateString)
    {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = null;
        try {
            d1 = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d1;
    }
}