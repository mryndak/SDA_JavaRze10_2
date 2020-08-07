package pl.sda.travel360.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.travel360.domain.Country;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String name);

    @Query("from Country c where " +
            "c.population > :minPopulation " +
            "or " +
            ":minPopulation = null")
    Collection<Country> findAllWithMinPopulation(Integer minPopulation);

}
