package com.autoirrigation.service;

import com.autoirrigation.model.Plot;
import com.autoirrigation.model.Slot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlotServiceImplTest {

	@Autowired
	PlotService plotService;

	@Test
	void getAllPlots() {
		List<Plot> allPlots = plotService.getAllPlots();
		assertThat(allPlots.size()).isGreaterThan(0);
	}

}
