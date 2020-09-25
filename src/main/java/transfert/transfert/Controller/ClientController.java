package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import transfert.transfert.DAO.ClientRepository;
import transfert.transfert.DAO.CompteRepository;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Compte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepos;
    @Autowired
    CompteRepository compteRpos;

    @RequestMapping("/accueil")
    public String index(Model model){
        model.addAttribute("clients", clientRepos.findAll());
        return "client/index";
    }

    @PostMapping("/add")
    public String add(@Validated Client client, BindingResult result){
        if(!(result.hasErrors())){
            try{
                this.addCompte(clientRepos.save(client));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/client/accueil";
    }

    public void addCompte(Client cl){
        Compte compte=new Compte();
        compte.setClient(cl);
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        compte.setDate_crea(format.format(date));
        compte.setMontant(6000);
        compte.setNumero(cl.getNci().substring(0,4)+compteRpos.findAll().size()+"-"+
                cl.getPrenom().substring(0,1)+cl.getNom().substring(0,1));
        compteRpos.save(compte);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name="id") int id, Model model){
        model.addAttribute("clients", clientRepos.findAll());
        model.addAttribute("client", clientRepos.findById(id));
        return "client/edit";
    }
    @PostMapping("/update/client")
    public String update(@ModelAttribute("client") Client client){
        try {
            Client clientUpdate=clientRepos.findById(client.getId());
            clientUpdate.setNom(client.getNom());
            clientUpdate.setPrenom(client.getPrenom());
            clientUpdate.setTelephone(client.getTelephone());
            clientUpdate.setNci(client.getNci());
            clientRepos.flush();

        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/client/accueil";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(name="id") int id, Model model){
        try{
            clientRepos.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/client/accueil";
    }
}
