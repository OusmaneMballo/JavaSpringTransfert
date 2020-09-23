package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepos;
    @RequestMapping("/accueil")
    public String index(Model model){
        model.addAttribute("client", clientRepos.findAll());
        return "client/index";
    }
}
