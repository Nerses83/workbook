package com.test.demo.controllers;

import com.test.demo.entity.WorkBook;
import com.test.demo.entity.WorkPlace;
import com.test.demo.service.WorkBookService;
import com.test.demo.service.WorkPlaceService;
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

@Controller
public class WorkPlaceController {

    @Autowired
    WorkPlaceService workPlaceService;

    @Autowired
    WorkBookService workBookService;

    @GetMapping("/workbook/{id}")
    public String getWorkPlace(@PathVariable Integer id, Model model) {

        WorkBook workBook = workBookService.getWorkBookById(id);
        model.addAttribute("workplace", workBook.getWorkPlaces());
        model.addAttribute("workBook", workBook);
        return "workPlace";
    }

    @GetMapping("/workbook/add/{id}")
    public String add(@PathVariable Integer id, Model model) {

        WorkBook workBook = workBookService.getWorkBookById(id);
        model.addAttribute("workBook", workBook);
        return "workplace/new";
    }

    @GetMapping("/workplace/delete/{id}/{book_id}")
    public String delete(@PathVariable Integer id, @PathVariable Integer book_id, Model model) {

        workPlaceService.deleteWorkPlace(id);
//        return "redirect:/workbook/"+book_id;
        return String.format("redirect:/workbook/%s", book_id);
    }


    @PostMapping("/workplace/add/")
    public String save(@RequestParam Integer id, String company, String country,
                       @RequestParam(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                       @RequestParam(value="endDate")   @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
                       boolean current ) {


        WorkBook workBook = workBookService.getWorkBookById(id);
        if(current) {
            for (WorkPlace workPlace : workBook.getWorkPlaces()) {
                if(workPlace.isCurrent()) {
                    workPlace.setCurrent(false);
                    workPlaceService.saveWorkPlace(workPlace);
                }
            }
        }
        WorkPlace workPlace = new WorkPlace(company, country, startDate, endDate, current);
        workPlace.setWorkBook(workBook);
        workPlaceService.saveWorkPlace(workPlace);
//        return "redirect:/workbook/"+id;
        return String.format("redirect:/workbook/%s", id);
    }

}
