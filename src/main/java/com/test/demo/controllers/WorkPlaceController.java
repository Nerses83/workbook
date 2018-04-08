package com.test.demo.controllers;

import com.test.demo.entity.WorkBook;
import com.test.demo.entity.WorkPlace;
import com.test.demo.service.WorkBookService;
import com.test.demo.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class WorkPlaceController {

    @Autowired
    WorkPlaceService workPlaceService;

    @Autowired
    WorkBookService workBookService;

    @GetMapping("/workbook/{id}")
    public String getWorkPlace(@PathVariable Integer id, Model model) {

        WorkBook workBook = workBookService.getWorkBookById(id);
        model.addAttribute("workBook", workBook);
        return "workPlace";
    }

    @GetMapping("/workbook/add/{id}")
    public String add(@PathVariable Integer id, Model model) {

        WorkBook workBook = workBookService.getWorkBookById(id);
        model.addAttribute("workBook", workBook);
        return "workplace/new";
    }

    @PostMapping("/workplace/add/")
    public String save(@RequestParam Integer id, String company, String country,
                       @RequestParam(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                       @RequestParam(value="endDate")   @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate ,
                       boolean current ) {

        if(startDate == null) startDate = new Date();
        if(endDate == null) endDate = new Date();

        WorkBook workBook = workBookService.getWorkBookById(id);
        if(current) {
            for (WorkPlace workPlace : workBook.getWorkPlaces()) {
                if(workPlace.isCurrent()) {
                    workPlace.setCurrent(false);
                    workPlaceService.saveWorkPlace(workPlace);
                    break;
                }
            }
        }
        WorkPlace workPlace = new WorkPlace(company, country, startDate, endDate, current);
        workPlace.setWorkBook(workBook);
        workPlaceService.saveWorkPlace(workPlace);
        return String.format("redirect:/workbook/%s", id);
    }


    @GetMapping("/workplace/delete/{id}/{book_id}")
    public String delete(@PathVariable Integer id, @PathVariable Integer book_id, Model model) {

        workPlaceService.deleteWorkPlace(id);
        return String.format("redirect:/workbook/%s", book_id);
    }





    @GetMapping("/workplace/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        WorkPlace workPlace = workPlaceService.getWorkPlaceById(id);
        model.addAttribute("workPlace", workPlace);
        return "workplace/edit";
    }

    @PostMapping("/workplace/update")
    public String update(@RequestParam String company, @RequestParam String country,
                         @RequestParam(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                         @RequestParam(value="endDate")   @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
                         boolean current, int id, int book_id) {

        WorkPlace workPlace = new WorkPlace(company, country, startDate, endDate, current);
        workPlace.setId(id);
        WorkBook workBook = workBookService.getWorkBookById(book_id);
        workPlace.setWorkBook(workBook);

        if(current){
            workPlaceService.updateWorkPlace(workBook.getWorkPlaces(), workPlace);
        } else {
            workPlaceService.saveWorkPlace(workPlace);
        }
        return String.format("redirect:/workbook/%s", book_id);
    }
}
