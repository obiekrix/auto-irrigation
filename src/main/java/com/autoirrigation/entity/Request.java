package com.autoirrigation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Request {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "IRRIGATION_TIME", nullable = false)
	private LocalDateTime irrigationTime;
	@Column(name = "IRRIGATED", nullable = false)
	private Boolean irrigated;
	@ManyToOne
	@JoinColumn(name = "SLOT_ID", nullable = false)
	private Slot slot;
	@Column(name = "HOUR", nullable = false)
	private Integer hour;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getIrrigationTime() {
		return irrigationTime;
	}

	public void setIrrigationTime(LocalDateTime irrigationTime) {
		this.irrigationTime = irrigationTime;
	}

	public Boolean getIrrigated() {
		return irrigated;
	}

	public void setIrrigated(Boolean status) {
		this.irrigated = status;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour=hour;
	}

}
