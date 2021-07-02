package pl.coderslab.charity;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@Controller

public class DonationController {

    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;
    private CategoryRepository categoryRepository;


    public DonationController(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }



    @GetMapping("/add")
    public String addDonation (Model model){
        model.addAttribute("donation", new Donation());

        return "addDonation";
    }

    @PostMapping("/add")
    @Transactional
    public String addDonation (@Valid @ModelAttribute  Donation donation, BindingResult violations){
        if(violations.hasErrors()){
            Hibernate.initialize(donation.getCategories());
            Hibernate.initialize(donation.getInstitution());
            return "addDonation";
        }
        donationRepository.save(donation);
        return "donationConfirmation";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {return institutionRepository.findAll();}

    @ModelAttribute("categories")
    public List<Category> categories() {return categoryRepository.findAll();}

}
