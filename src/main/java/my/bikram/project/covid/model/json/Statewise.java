package my.bikram.project.covid.model.json;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class Statewise {
	private String active;
	private String confirmed;
	private String deaths;
	private String deltaconfirmed;
	private String deltadeaths;
	private String deltarecovered;
	private String lastupdatedtime;
	private String migratedother;
	private String recovered;
	private String state;
	private String statecode;
	private String statenotes;

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	public String getDeltaconfirmed() {
		return deltaconfirmed;
	}

	public void setDeltaconfirmed(String deltaconfirmed) {
		this.deltaconfirmed = deltaconfirmed;
	}

	public String getDeltadeaths() {
		return deltadeaths;
	}

	public void setDeltadeaths(String deltadeaths) {
		this.deltadeaths = deltadeaths;
	}

	public String getDeltarecovered() {
		return deltarecovered;
	}

	public void setDeltarecovered(String deltarecovered) {
		this.deltarecovered = deltarecovered;
	}

	public String getLastupdatedtime() {
		return lastupdatedtime;
	}

	public void setLastupdatedtime(String lastupdatedtime) {
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
		LocalDateTime time = LocalDateTime.parse(lastupdatedtime, formatter);
		this.lastupdatedtime = time
				.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
				.toString();
	}

	public String getMigratedother() {
		return migratedother;
	}

	public void setMigratedother(String migratedother) {
		this.migratedother = migratedother;
	}

	public String getRecovered() {
		return recovered;
	}

	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getStatenotes() {
		return statenotes;
	}

	public void setStatenotes(String statenotes) {
		this.statenotes = statenotes;
	}
}
