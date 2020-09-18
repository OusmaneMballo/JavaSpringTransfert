package transfert.transfert.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import transfert.transfert.DAO.CaissierRepository;
import transfert.transfert.Model.Caissier;

@Controller
@RequestMapping("/caissier")
public class CaissierController {
    @Autowired
    CaissierRepository caissierRepos;
    @PostMapping("/addCaissier")
    public String addCaissier(@Validated Caissier caissier, BindingResult result, Model model){
        if(!(result.hasErrors())){
            caissierRepos.save(caissier);
        }
        model.addAttribute("caissiers", caissierRepos.findAll());
        return "caissier";
    }

}
