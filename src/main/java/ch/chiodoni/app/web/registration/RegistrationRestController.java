package ch.chiodoni.app.web.registration;

import ch.chiodoni.app.domain.country.entity.Country;
import ch.chiodoni.app.domain.country.repository.CountryRepository;
import ch.chiodoni.app.domain.user.entity.User;
import ch.chiodoni.app.domain.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RegistrationRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationRestController.class);

    //TODO Fix to use CustomDateEditor when parsing a JSON date
    //Bug: currently uses dates with format yyyy-MM-dd
    @InitBinder()
    public void customizeConversions(WebDataBinder binder) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }

    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired(required = true)
    private CountryRepository countryRepository;

    @RequestMapping(value = "/rest/registration", method = RequestMethod.GET)
    public String showRegistrationPage(@ModelAttribute("user") final User user, ModelMap model) {
        LOGGER.debug("registration");
        return "ng-registration";
    }

    @RequestMapping(value = "/rest/countries", method = RequestMethod.GET)
    public @ResponseBody List<Country> getCountries(@ModelAttribute("user") final User user, ModelMap model) {
        LOGGER.debug("getCountries");
        return countryRepository.find();
    }

    /**
     * This method receive a User as JSON data in the request
     * the format of the incoming data is a map with the following format:
     * Object { name="Fede", lastName="Yanke", email="fgh@hc.ch", birthday="1977-01-26", country="IT", phone="(999)888-3333" }
     * TODO handle exception when birthday has the wrong format
     * TODO how can we have 2 @RequestBody parameters in method when using JSON?
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/rest/registration", method = RequestMethod.POST)
    public @ResponseBody Long registerUser(@RequestBody @Valid final User user, final BindingResult bindingResult, ModelMap model) {
        LOGGER.debug("Registering JSON user {}.", user);

        if (user.isUserTooOld()) {
            bindingResult.rejectValue("birthday", "validation.user.birthday.too.old");
        }

        if (bindingResult.hasErrors()) {
            //TODO how to return a list of errors in JSON? now errors go to the inside the HTTP 500 error page as text
            throw new RuntimeException(""+bindingResult.getAllErrors());
        }

        //TODO handle UniqueConstrainException when same email
        userRepository.save(user);

        LOGGER.debug("User has been registered, {}", user);
        return user.getId();
    }
}
