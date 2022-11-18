package com.autoirrigation.rest;

import com.autoirrigation.model.Plot;
import com.autoirrigation.model.Slot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class IrrigationControllerTest {

	Plot plot;
	Slot slot;

	@Autowired
	IrrigationController irrigationController;

	@BeforeEach
	void setUp() {
		plot = new Plot();
		plot.setName("plot1");
		plot.setSoilMoistureLevel(BigDecimal.TEN);

		slot = new Slot();
		slot.setAmountOfWater(20);
		slot.setPeriod(12);
		slot.setPlotId(1L);
	}

	@Test
	void addPlot() {
		ResponseEntity<Void> responseEntity = irrigationController.addPlot(plot);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	void addSlot() {
		ResponseEntity<Void> responseEntity = irrigationController.addSlot(slot);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	void getAllPlots() {
		ResponseEntity<List<Plot>> responseEntity = irrigationController.getAllPlots();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void getAllSlotsForPlot() {
		ResponseEntity<List<Slot>> responseEntity = irrigationController.getAllSlotsForPlot(1L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void removeSlot() {
		ResponseEntity<Long> responseEntity = irrigationController.removeSlot(9L);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void requestIrrigation() {
		ResponseEntity<Integer> responseEntity = irrigationController.requestIrrigation();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
