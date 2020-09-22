package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.CaissierRepository;
import transfert.transfert.Model.Caissier;

@Controller
@RequestMapping("/caissier")
public class CaissierController {
    @Autowired
    CaissierRepository caissierRepos;

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
            caissierRepos.save(caissier);
        }
        model.addAttribute("caissiers", caissierRepos.findAll());
        return "caissier/index";
    }
    @GetMapping("/deletecaissier/{id}")
    public String dellete(@PathVariable(name="id") int idcaissier, Model model){
        caissierRepos.deleteById(idcaissier);
        model.addAttribute("caissiers", caissierRepos.findAll());
        return "caissier/index";
    }
    @GetMapping("/editcaissier/{id}")
    public String edit(@PathVariable(name="id") int idcaissier, Model model){
        return "caissier/index";
    }

}
