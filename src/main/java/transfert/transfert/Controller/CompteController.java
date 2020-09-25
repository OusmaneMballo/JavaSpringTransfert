package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.ClientRepository;
import transfert.transfert.DAO.CompteRepository;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Compte;

@Controller
@RequestMapping("/compte")
public class CompteController{
    @Autowired
    CompteRepository compteRepos;
    @Autowired
    ClientRepository clientRepos;

    @GetMapping("/accueil")
    public String index(Model model){
        model.addAttribute("comptes", compteRepos.findAll());
        model.addAttribute("clients", clientRepos.findAll());
        return "compte/index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("compte") Compte compte){

        /*if (!result.hasErrors()){

        }*/
        try{
            compte.setClient((Client)clientRepos.findById(11));
            compteRepos.save(compte);
            return "redirect:/compte/accueil";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "compte/index";
    }
}
