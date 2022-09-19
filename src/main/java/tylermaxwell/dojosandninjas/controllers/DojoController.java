package tylermaxwell.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tylermaxwell.dojosandninjas.models.Dojo;
import tylermaxwell.dojosandninjas.services.DojoService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DojoController {

    @Autowired
    DojoService service;

    @GetMapping("/dojos")
    public String index(@ModelAttribute("dojos") Dojo dojo, Model model){
        List<Dojo> dojos = service.allDojos();
        model.addAttribute("dojos", dojos);
        return "/dojos/new.jsp";
     }

    // CREATE
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model){
            List<Dojo> dojos = service.allDojos();
            model.addAttribute("dojos", dojos);
            return "/dojos/new.jsp";
        }

    @PostMapping("/dojos")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Dojo> dojos = service.allDojos();
            model.addAttribute("dojos", dojos);
            return "/dojos/new.jsp";
        } else {
            service.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @GetMapping("dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Dojo dojo = service.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/show.jsp";
    }















}
