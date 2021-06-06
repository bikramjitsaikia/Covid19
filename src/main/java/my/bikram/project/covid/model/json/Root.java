package my.bikram.project.covid.model.json;

import java.util.List;

public class Root {
	private List<CasesTimeSeries> cases_time_series;
	private List<Statewise> statewise;
	private List<Tested> tested;

	public List<CasesTimeSeries> getCases_time_series() {
		return cases_time_series;
	}

	public void setCases_time_series(List<CasesTimeSeries> cases_time_series) {
		this.cases_time_series = cases_time_series;
	}

	public List<Statewise> getStatewise() {
		return statewise;
	}

	public void setStatewise(List<Statewise> statewise) {
		this.statewise = statewise;
	}

	public List<Tested> getTested() {
		return tested;
	}

	public void setTested(List<Tested> tested) {
		this.tested = tested;
	}
}
