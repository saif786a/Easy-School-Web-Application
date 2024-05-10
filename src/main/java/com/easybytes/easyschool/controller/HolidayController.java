package com.easybytes.easyschool.controller;

import com.easybytes.easyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        } else if (null != display && display.equals("federal")) {
            model.addAttribute("federal", true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
            
        }

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" April 11 ", "Eid-ul-Fitr", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 27 ", "Diwali", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas Day", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 26 ", "Republic Day", Holiday.Type.FEDERAL),
                new Holiday(" Aug 15 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Oct 2 ", "Gandhi Jayanti", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }

}

