package com.autoirrigation.service;

import com.autoirrigation.model.Slot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SlotServiceImplTest {

	@Autowired
	SlotService slotService;

	@Test
	void removeSlot() {
		Long removedSlotId = slotService.removeSlot(9L);
		assertThat(removedSlotId).isEqualTo(9L);

	}

	@Test
	void getAllSlotsForPlot() {
		List<Slot> allSlotsForPlot = slotService.getAllSlotsForPlot(1L);
		assertThat(allSlotsForPlot.size()).isGreaterThan(0);
	}
}
