package my.bikram.project.covid;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import my.bikram.project.covid.model.json.Root;
import my.bikram.project.covid.model.json.Statewise;

public class ReadCovidJSON {

	private static String api = "https://api.covid19india.org/data.json";
	public static void main(String[] args) {
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		DateTimeFormatter formatter = builder.appendValue(ChronoField.DAY_OF_MONTH)
		    .appendLiteral("/")
		    .appendValue(ChronoField.MONTH_OF_YEAR)
		    .appendLiteral("/")
		    .appendValue(ChronoField.YEAR)
		    .appendLiteral(" ")
		    .appendValue(ChronoField.HOUR_OF_DAY)
		    .appendLiteral(":")
		    .appendText(ChronoField.MINUTE_OF_HOUR)
		    .appendLiteral(":")
		    .appendText(ChronoField.SECOND_OF_MINUTE)
		    .toFormatter(); 
		LocalDateTime time = LocalDateTime.parse("31/5/2021 20:59:07", formatter);
		System.out.println(time);
//		getStatesString();
//		getStates();
//		getStateArray();
	}

	private static void getStates()
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    Root datalist = restTemplate.getForObject(api, Root.class);
	    List<Statewise> states =  datalist.getStatewise();
	    if (states.size() == 0)
	    	System.out.println("empty");
	    for (Statewise s : states) {
	    	System.out.println(s.getState());
	    }
	}
}
