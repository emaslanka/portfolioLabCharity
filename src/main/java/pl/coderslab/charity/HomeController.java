package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    //Display List of institutions + amount of bags + amount of presents
    @RequestMapping("/")
    public String homeAction(Model model){

        int amountOfDonation = donationRepository.countAllDonations();
        Integer amountOfBags = donationRepository.countAllBags();;
        List<Institution> institutionList= institutionRepository.findAll() ;
        model.addAttribute("institutions", institutionList);
        model.addAttribute("donations", amountOfDonation);
        model.addAttribute("bags", amountOfBags);

        return "index";
    }
}
