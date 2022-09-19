package tylermaxwell.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tylermaxwell.dojosandninjas.models.Dojo;
import tylermaxwell.dojosandninjas.models.Ninja;
import tylermaxwell.dojosandninjas.services.DojoService;
import tylermaxwell.dojosandninjas.services.NinjaService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    @Autowired
    DojoService dojoService;


    @GetMapping("/ninjas")
    public String index(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Ninja> ninjas = ninjaService.allNinjas();
        model.addAttribute("ninjas", ninjas);
        return "/ninjas/new.jsp";
    }

    // CREATE
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Ninja> ninjas = ninjaService.allNinjas();
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojos", dojos);
        return "/ninjas/new.jsp";
    }

    @PostMapping("/ninjas")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        System.out.println(ninja);
        if (result.hasErrors()) {
            List<Ninja> ninjas = ninjaService.allNinjas();
            model.addAttribute("ninjas", ninjas);
            return "/ninjas/new.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }
}
