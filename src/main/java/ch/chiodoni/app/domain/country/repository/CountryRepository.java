package ch.chiodoni.app.domain.country.repository;

import ch.chiodoni.app.domain.country.entity.Country;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 26.11.12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public interface CountryRepository extends JpaRepository<Country, String> {

    @Cacheable("countries")
    public Country findOne(String code);

    @Cacheable("countries")
    @Query("SELECT c FROM Country c ORDER BY c.name")
    public List<Country> find();

    @Cacheable("countries")
    public List<Country> findByNameStartingWithIgnoreCaseOrderByNameAsc(String startingWith);

}
