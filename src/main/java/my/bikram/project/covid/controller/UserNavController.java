package my.bikram.project.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.bikram.project.covid.Covid19DataService;
import my.bikram.project.covid.model.json.Statewise;

@Controller
public class UserNavController {
	@Autowired
	private Covid19DataService covid19DataService;

	@GetMapping("/data_table")
	public String viewUsersList(Model model) {
	    model.addAttribute("total",getTotal());
	    model.addAttribute("states",getStatesData());
	    
	    model.addAttribute("active", "tables");

		return "data_table";
	}

	@GetMapping("/data_time_series")
	public String viewTimeSeries(Model model) {
		model.addAttribute("series_data", covid19DataService.getTimeSeries());
		model.addAttribute("active", "time_series");
		return "data_time_series";
	}

	@GetMapping("/data_pie_statewise")
	public String viewPieStatewise(Model model) {
		model.addAttribute("states", getStatesData());
	    model.addAttribute("active", "pie_statewise");
		return "data_pie_statewise";
	}

	public List<Statewise> getStatesData() {
	    List<Statewise> states =  covid19DataService.getStatesData();   
	    return states;
	}

	public Statewise getTotal() {
	    List<Statewise> states =  covid19DataService.getStatesData();   
	    Statewise total = new Statewise();
	    for (Statewise state : states) {
	    	if (state.getState().equals("Total")) {
	    		total = state;
	    		break;
	    	}
	    }
	    return total;
	}
}