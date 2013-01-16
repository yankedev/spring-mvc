package ch.chiodoni.app.web.registration;

import ch.chiodoni.app.domain.country.entity.Country;
import ch.chiodoni.app.domain.country.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired(required = true)
    private CountryRepository countryRepository;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Country> countries(@RequestParam(value = "startingWith", required = false, defaultValue = "") String startingWith) {
        LOGGER.debug("Finding countries startingWith {}", startingWith);
        return countryRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc(startingWith);
    }

    @RequestMapping(value = "/country/{code}", method = RequestMethod.GET)
    public
    @ResponseBody
    Country country(@PathVariable("code") String code) {
        LOGGER.debug("Finding county by code {}", code);
        return countryRepository.findOne(code.toUpperCase());
    }
}
