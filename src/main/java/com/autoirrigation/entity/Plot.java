package com.autoirrigation.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Plot {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "SOIL_MOISTURE_LEVEL", nullable = false)
	private BigDecimal soilMoistureLevel;
	@OneToMany(mappedBy = "plot")
	private Set<Slot> slots;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSoilMoistureLevel() {
		return soilMoistureLevel;
	}

	public void setSoilMoistureLevel(BigDecimal soilMoistureLevel) {
		this.soilMoistureLevel = soilMoistureLevel;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
	}
}
