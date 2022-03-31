package fr.limayrac.banque.controller;


import fr.limayrac.banque.Service.ClientService;
import fr.limayrac.banque.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/client")
public class ClientsController {

    @Autowired
    private ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientsController.class);

    @RequestMapping("/lister")
    @ResponseBody
    public ModelAndView listerClient(){
        return new ModelAndView("client/ListerClients", "clients", clientService.getClients());
    }
    @RequestMapping("/lister/{id}")
    @ResponseBody
    public ModelAndView detailClient(@PathVariable int id){
        return new ModelAndView("client/client", "client", clientService.getClient(id).orElse(null));
    }

    @GetMapping("/creer")
    public String createClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client/createClientForm";
    }

    @PostMapping("/creer")
    public RedirectView submitCreateClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return new RedirectView("lister");
    }

    @RequestMapping("/effacer/{id}")
    @ResponseBody
    public RedirectView deleteClient(@PathVariable int id){
        clientService.deleteClient(id);
        return new RedirectView("lister");
    }
}
