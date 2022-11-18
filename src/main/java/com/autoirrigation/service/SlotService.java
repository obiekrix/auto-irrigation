package com.autoirrigation.service;

import com.autoirrigation.model.IrrigationRequest;
import com.autoirrigation.model.Slot;

import java.util.List;

public interface SlotService {

	void addSlot(Slot slot);

	Long removeSlot(Long id);

	List<Slot> getAllSlotsForPlot(Long plotId);

	Long configureSlot(Long id, Slot slot);

}
