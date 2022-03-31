package fr.limayrac.banque.controller;

import fr.limayrac.banque.Service.ClientService;
import fr.limayrac.banque.Service.CompteService;
import fr.limayrac.banque.model.Client;
import fr.limayrac.banque.model.Compte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/compte")
public class ComptesController {

    private static final Logger logger = LoggerFactory.getLogger(ClientsController.class);

    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/lister")
    @ResponseBody
    public ModelAndView listerCompte(){
        return new ModelAndView("compte/ListerComptes", "comptes", compteService.getComptes());
    }
    @RequestMapping("/lister/{id}")
    @ResponseBody
    public ModelAndView detailCompte(@PathVariable int id){
        return new ModelAndView("compte/compte", "compte", compteService.getCompte(id).orElse(null));
    }

    @GetMapping("/creer")
    public String createCompte(Model model){
        Compte compte = new Compte();
        model.addAttribute("compte", compte);
        Iterable<Client> clients = clientService.getClients();
        model.addAttribute("clients",clients);
        return "compte/createCompteForm";
    }

    @PostMapping("/creer")
    public RedirectView submitCreateClient(@ModelAttribute("compte") Compte compte){
        compteService.saveCompte(compte);
        return new RedirectView("lister");
    }

    @RequestMapping("/effacer/{id}")
    @ResponseBody
    public RedirectView deleteCompte(@PathVariable int id){
        compteService.deleteCompte(id);
        return new RedirectView("lister");
    }
}
