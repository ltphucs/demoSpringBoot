package com.cg.demo.controller.web;

import com.cg.demo.model.City;
import com.cg.demo.service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web")
public class CityWebController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public String cities(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "/city/index";
    }

    @PostMapping("/cities/add")
    public ModelAndView addCity(@ModelAttribute City city){
        String message;
        ModelAndView modelAndView = new ModelAndView("/city/add");
        try {
            cityService.save(city);
            message="Add new success";modelAndView.addObject("error", "success");


        }catch (Exception ex){
            message="Add new city error";
            modelAndView.addObject("error", "error");
        }
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @GetMapping("/cities/add")
    public ModelAndView showAddCity(){
        ModelAndView modelAndView = new ModelAndView("/city/add");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @GetMapping("/cities/edit/{id}")
    public ModelAndView showEditCity(@PathVariable long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city",city);
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("/eror/404");
        modelAndView.addObject("message","Data not found !");

        return modelAndView;
    }
    @GetMapping("/cities/delete/{id}")
    public ModelAndView showDeleteCity(@PathVariable long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city",city.get());
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("/eror/404");
        modelAndView.addObject("message","Data not found !");

        return modelAndView;
    }

    @PostMapping("/cities/edit")
    public ModelAndView editCity(@ModelAttribute City city){
        String message;
        ModelAndView modelAndView = new ModelAndView("/city/add");
        try {
            cityService.save(city);
            message="<strong>Success!</strong> Your city has been update successfully..";
            modelAndView.addObject("error", "success");

        }catch (Exception ex){
            message="<strong>Error!</strong> Your city has been update error..";
            modelAndView.addObject("error", "error");
        }
        modelAndView.addObject("city",city);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping("/cities/delete")
    public ModelAndView deleteCity(@ModelAttribute City city){
        String message;
        try {
            cityService.remove(city.getId());
            return new ModelAndView("redirect:/web/cities");
        }catch (Exception ex){
            message="<strong>Error!</strong> Your city has been update error..";

            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("error", "error");
            modelAndView.addObject("city",city);
            modelAndView.addObject("message", message);
            return modelAndView;

        }
    }
}
