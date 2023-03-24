package com.parking.parking.controller;

import com.parking.parking.controller.utils.Slot;
import com.parking.parking.models.DbConfig;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class parkingController {
    DbConfig dbConfig = new DbConfig();
    @GetMapping("/hello")
    public ModelAndView hello(Model model){
        ModelAndView mav = new ModelAndView("index");
        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot("Street C", "true", "22","url__3","position"));
        mav.addObject("slots", slots);
        return mav;
    }
    @GetMapping("/search")
    public ModelAndView Search(Model model) throws SQLException {
        ModelAndView mav = new ModelAndView("index");
        List<Slot> slots = new ArrayList<>();
        String query = "select * from places;";
        List<String[]> streets = dbConfig.executeQuery(query);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/parking-lots");
        for (String[] street : streets) {
            slots.add(new Slot(street[0], street[1], street[3]+" Street",  "url","position"));
            System.out.println(street[3]);
        }

        model.addAttribute("slots",slots);
        return mav;
    }

    @GetMapping("/parking-lots")
    public ModelAndView Details(@RequestParam("id") String id){
        ModelAndView mav = new ModelAndView("Details");
        System.out.println(id);
       return mav;
    }
}
