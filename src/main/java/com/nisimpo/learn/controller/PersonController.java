package com.nisimpo.learn.controller;

import com.nisimpo.learn.models.Person;
import com.nisimpo.learn.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepo;

    @GetMapping("/")
    public String index(Model model){
        List<Person> persons = (List<Person>) personRepo.findAll();
        model.addAttribute("persons",persons);
        return "index";
    }

    @GetMapping("register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("register.html");
        return mv;
    }

    @PostMapping("person/save")
    public String savePerson(Person person,Model model){
        personRepo.save(person);
        List<Person> persons = (List<Person>) personRepo.findAll();
        model.addAttribute("persons",persons);
        return "index";
    }

    /*@GetMapping("home")
    public String goHome(Model model){
        List<Person> persons = (List<Person>) personRepo.findAll();
        model.addAttribute("persons",persons);
        return "index";
    }*/
}
