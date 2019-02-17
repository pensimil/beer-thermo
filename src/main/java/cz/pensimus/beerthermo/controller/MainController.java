package cz.pensimus.beerthermo.controller;

import cz.pensimus.beerthermo.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("temps", temperatureService.findAll());
        return "index";
    }
}
