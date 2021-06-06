package my.bikram.project.covid;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import my.bikram.project.covid.model.json.CasesTimeSeries;
import my.bikram.project.covid.model.json.Root;
import my.bikram.project.covid.model.json.Statewise;

@Service
public class Covid19DataService {

    private String api = "https://api.covid19india.org/data.json";

	@Cacheable("coviddata")
	public Root getCovidData() {
	    System.out.println("Fetching the data;");
	    RestTemplate restTemplate = new RestTemplate();
	    Root root = restTemplate.getForObject(api, Root.class);
	    return root;
	}
	
	@Cacheable("states")
	public List<Statewise> getStatesData() {
		Root root = getCovidData();
	    List<Statewise> states =  root.getStatewise();	    
	    states.removeIf(n -> (n.getState().equals("State Unassigned")));
	    return states;
	}
	
	@Cacheable("timeseries")
	public List<CasesTimeSeries> getTimeSeries() {
		Root root = getCovidData();
	    List<CasesTimeSeries> ts =  root.getCases_time_series();	    
	    return ts;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}
}
