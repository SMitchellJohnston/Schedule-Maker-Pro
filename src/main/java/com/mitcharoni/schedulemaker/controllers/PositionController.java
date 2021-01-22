package com.mitcharoni.schedulemaker.controllers;

import com.mitcharoni.schedulemaker.models.Employee;
import com.mitcharoni.schedulemaker.models.Position;
import com.mitcharoni.schedulemaker.models.data.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("position")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping
    public String displayPositions(Model model) {
        model.addAttribute("title", "Positions");
        model.addAttribute("positions", positionRepository.findAll());
        return "position/index";
    }

    @GetMapping("create")
    public String displayCreatePositionForm(Model model) {
        model.addAttribute("title","Create New Position");
        model.addAttribute(new Position());
        return "position/create";
    }

    @PostMapping("create")
    public String processCreatePositionForm(@ModelAttribute("position")Position newPosition, Errors errors,
                                            Model model) {
        positionRepository.save(newPosition);
        return "redirect:";
    }
}
