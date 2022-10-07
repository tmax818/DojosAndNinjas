package tylermaxwell.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tylermaxwell.dojosandninjas.models.Dojo;
import tylermaxwell.dojosandninjas.models.Ninja;
import tylermaxwell.dojosandninjas.services.DojoService;
import tylermaxwell.dojosandninjas.services.NinjaService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private final DojoService dojoService;
    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    private final NinjaService ninjaService;


    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute(value = "dojo") Dojo dojo, Model model){
        List<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojo", dojo);
        model.addAttribute("dojos", dojos);
        return "/dojos/new.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute(value = "dojo") Dojo dojo, BindingResult result){
        if (result.hasErrors()) {
            return "/dojos/new.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }

    @GetMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo",dojo);
        return "/dojos/show.jsp";
    }

    @GetMapping("/ninjas")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninja", ninja);
        return "/ninjas/new.jsp";
    }

    @PostMapping("/ninjas")
    public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result){
        String id = String.valueOf(ninja.getDojo().getId());
        if (result.hasErrors()) {
            return "/ninjas/new.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return String.format("redirect:/dojos/%s", id);
        }
    }
}
