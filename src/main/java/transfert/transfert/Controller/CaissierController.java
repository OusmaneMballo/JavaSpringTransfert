package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import transfert.transfert.DAO.CaissierRepository;
import transfert.transfert.DAO.CompteRepository;
import transfert.transfert.Model.Caissier;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Compte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/caissier")
public class CaissierController {
    @Autowired
    CaissierRepository caissierRepos;
    @Autowired
    CompteRepository compteRepos;

    @GetMapping("/accueil")
    public String index(Model model){
        model.addAttribute("caissiers", caissierRepos.findAll());
        return "caissier/index";
    }

    @PostMapping("/addcaissier")
    public String addCaissier(@Validated Caissier caissier, BindingResult result, Model model){
        if(!(result.hasErrors())){

            String code=caissier.getNci().substring(0,4)+"-"+
                    caissier.getNom().substring(0,1)+caissier.getPrenom().substring(0,1);
            caissier.setCode(code);
            this.addCompte(caissierRepos.save(caissier));
        }
        return "redirect:/caissier/accueil";
    }

    public void addCompte(Caissier cl){
        Compte compte=new Compte();
        compte.setCaissier(cl);
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        compte.setDate_crea(format.format(date));
        compte.setMontant(6000);
        compte.setNumero(cl.getNci().substring(0,4)+compteRepos.findAll().size()+"-"+
                cl.getPrenom().substring(0,1)+cl.getNom().substring(0,1));
        compteRepos.save(compte);
    }

    @GetMapping("/deletecaissier/{id}")
    public String dellete(@PathVariable(name="id") int idcaissier, Model model){
        caissierRepos.deleteById(idcaissier);
        model.addAttribute("caissiers", caissierRepos.findAll());
        return "caissier/index";
    }
    //Edit avec ajax
   /* @GetMapping("/editcaissier/{id}")
    public @ResponseBody Caissier edit(@PathVariable(name="id") int idcaissier){
        return caissierRepos.findById(idcaissier);
    }*/
    @GetMapping("/editcaissier/{id}")
    public String edit(@PathVariable(name="id") int idcaissier, Model model){
        model.addAttribute("caissiers", caissierRepos.findAll());
        model.addAttribute("caissier", caissierRepos.findById(idcaissier));
        return "caissier/edit";
    }

    @PostMapping("/updatecaissier/caissier")
    public String update(@ModelAttribute("caissier") Caissier caissier){
        try{
            Caissier updateCaissier=caissierRepos.findCaissierByCode(caissier.getCode());
            if(updateCaissier!=null){
                updateCaissier.setNumContrat(caissier.getNumContrat());
                updateCaissier.setNom(caissier.getNom());
                updateCaissier.setPrenom(caissier.getPrenom());
                updateCaissier.setTelephone(caissier.getTelephone());
                caissierRepos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/caissier/accueil";
    }

}
