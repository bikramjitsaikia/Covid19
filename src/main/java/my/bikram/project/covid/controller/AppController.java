package my.bikram.project.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import my.bikram.project.covid.Covid19DataService;
import my.bikram.project.covid.User;
import my.bikram.project.covid.UserRepository;
import my.bikram.project.covid.model.json.Statewise;

@Controller
public class AppController {

	@Autowired
	private UserRepository repo;
		
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("error", "");
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user, Model model) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setEmail(user.getEmail().toLowerCase());
		user.setPassword(encoder.encode(user.getPassword()));
		if (repo.findByEmail(user.getEmail().toLowerCase()) != null) {
			model.addAttribute("error", "The user already exists. Please choose a different user");
			return "signup_form";
		}
		repo.save(user);
		return "register_success";
	}
}
