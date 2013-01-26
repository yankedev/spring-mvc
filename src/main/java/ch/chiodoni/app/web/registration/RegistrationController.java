package ch.chiodoni.app.web.registration;

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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @InitBinder(value = "user")
    public void customizeConversions(WebDataBinder binder) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }

    @Autowired(required = true)
    private UserRepository userRepository;

    @Autowired(required = true)
    private CountryRepository countryRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(@ModelAttribute("user") final User user, ModelMap model) {
        LOGGER.debug("registration");
        model.addAttribute("countries", countryRepository.find());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") @Valid final User user, final BindingResult bindingResult, ModelMap model) {
        LOGGER.debug("Registering user {}.", user);

        if (user.isUserTooOld()) {
            bindingResult.rejectValue("birthday", "validation.user.birthday.too.old");
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userRepository.save(user);

        LOGGER.debug("User has been registered, {}", user);

        return "done";

    }
}
