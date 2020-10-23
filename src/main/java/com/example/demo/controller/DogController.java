package com.example.demo.controller;

import com.example.demo.model.Dog;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dog")
public class DogController {
    @Autowired
    DogService dogService;

    @GetMapping()
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("dogList", dogService.findAll());
        return mav;
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Dog>> findAll(){
        return new ResponseEntity<>(dogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("dog", new Dog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("dog") Dog dog) {
        dogService.save(dog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("dog", new Dog());
        modelAndView.addObject("message", "New dog created successfully");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Dog dog, Model model) {
        if (dog != null) {
            model.addAttribute("dog", dog);
            return "/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("dog") Dog dog) {
        dogService.save(dog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("dog", dog);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Dog dog, Model model) {
        if (dog != null) {
            model.addAttribute("dog", dog);
            return "delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {
        dogService.delete(id);
        return "redirect:";
    }
}
