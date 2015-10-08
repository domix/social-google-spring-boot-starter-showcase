package org.springframework.social.showcase.google;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.google.api.Google;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by domix on 03/10/15.
 */
@Controller
public class GoogleProfileController {

  @Inject
  private ConnectionRepository connectionRepository;

  @RequestMapping(value = "/google", method = RequestMethod.GET)
  public String home(Principal currentUser, Model model) {
    Connection<Google> connection = connectionRepository.findPrimaryConnection(Google.class);
    if (connection == null) {
      return "redirect:/connect/google";
    }
    model.addAttribute("profile", connection.getApi().plusOperations().getGoogleProfile());
    return "google/profile";
  }
}
