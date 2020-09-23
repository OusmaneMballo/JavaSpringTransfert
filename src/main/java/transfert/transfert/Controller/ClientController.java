package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.ClientRepository;
import transfert.transfert.Model.Client;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepos;
    @RequestMapping("/accueil")
    public String index(Model model){
        model.addAttribute("clients", clientRepos.findAll());
        return "client/index";
    }

    @PostMapping("/add")
    public String add(@Validated Client client, BindingResult result){
        if(!(result.hasErrors())){
            try{
                clientRepos.save(client);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/client/accueil";
    }
}
