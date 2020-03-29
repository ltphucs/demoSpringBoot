package com.cg.demo.controller.web;

import com.cg.demo.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/")
public class CityWebAjaxController {

    @GetMapping("/cities-ajax")git
    public String cities(Model model){
        return "/city/ajax-view/index";
    }

}
