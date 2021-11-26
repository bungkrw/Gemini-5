package th.ac.mahidol.ict.Gemini5_OCS.controller;

import th.ac.mahidol.ict.Gemini5_OCS.model.User;
import th.ac.mahidol.ict.Gemini5_OCS.model.UserFactory;
import th.ac.mahidol.ict.Gemini5_OCS.repository.ScienceFormRepository;
import th.ac.mahidol.ict.Gemini5_OCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScienceFormRepository scienceFormRepository;

    @GetMapping("/login")
    public  String showLoginPage(){
        return "login"; }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser("Astronomer");
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model){
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser == null){
            // Encode password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            // Save user
            userRepository.save(user);
            return "login";
        }
        model.addAttribute("error", "This username has already been taken");
        return "register_form";
    }
}
