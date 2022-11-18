package com.autoirrigation.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
public class Slot {
	@Id
	@GeneratedValue
	private Long id;
	@Min(0)
	@Max(23)
	@Column(name = "PERIOD", nullable = false)
	private Integer period;
	@Column(name = "AMOUNT_OF_WATER", nullable = false)
	private Integer amountOfWater;
	@ManyToOne
	@JoinColumn(name = "PLOT_ID", nullable = false)
	private Plot plot;
	@OneToMany(mappedBy = "slot")
	private Set<Request> requests;

	public Long getId() {
		return id;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getAmountOfWater() {
		return amountOfWater;
	}

	public void setAmountOfWater(Integer amountOfWater) {
		this.amountOfWater = amountOfWater;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}
}
