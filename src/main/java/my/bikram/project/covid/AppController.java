package my.bikram.project.covid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import my.bikram.project.covid.model.json.Root;
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
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		String api = "https://api.covid19india.org/data.json";
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
	    RestTemplate restTemplate = new RestTemplate();
	     
	    Root datalist = restTemplate.getForObject(api, Root.class);
	    List<Statewise> states =  datalist.getStatewise();	    
	    Statewise total = new Statewise();
	    for (Statewise state : states) {
	    	if (state.getState().equals("Total")) {
	    		total = state;
	    		break;
	    	}
	    }
	    states.removeIf(n -> (n.getState().equals("State Unassigned")
	    				   || n.getState().equals("Total")));

	    model.addAttribute("states", states);
	    model.addAttribute("total", total);

		return "users";
	}
	
	@GetMapping("/time_series")
	public String viewTimeSeries(Model model) {
		return "time_series";
	}
}
