package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {


    // amount of given presents
    @Query("SELECT COUNT (id) FROM Donation")
    int countAllDonations();

    // quantity of bags
    @Query("SELECT SUM(quantity) FROM Donation ")
    Integer countAllBags();
}
