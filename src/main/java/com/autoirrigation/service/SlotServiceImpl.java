package com.autoirrigation.service;

import com.autoirrigation.SensorAvailability;
import com.autoirrigation.entity.Plot;
import com.autoirrigation.entity.Request;
import com.autoirrigation.mapper.PlotMapper;
import com.autoirrigation.mapper.SlotMapper;
import com.autoirrigation.model.IrrigationRequest;
import com.autoirrigation.model.Slot;
import com.autoirrigation.repository.PlotRepository;
import com.autoirrigation.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class SlotServiceImpl implements SlotService {

	private final SlotRepository slotRepository;
	private final PlotRepository plotRepository;
	private final SlotMapper slotMapper;

	@Autowired
	public SlotServiceImpl(SlotRepository slotRepository, PlotRepository plotRepository, SlotMapper slotMapper) {
		this.slotRepository = slotRepository;
		this.plotRepository = plotRepository;
		this.slotMapper = slotMapper;
	}

	@Override
	public void addSlot(Slot slot) {
		com.autoirrigation.entity.Slot thisSlot = slotMapper.modelToEntity(slot);
		Plot plot = plotRepository.getById(slot.getPlotId());
		thisSlot.setPlot(plot);
		slotRepository.save(thisSlot);
	}

	@Override
	public Long removeSlot(Long id) {
		com.autoirrigation.entity.Slot slot = slotRepository.getById(id);
		slotRepository.delete(slot);
		return slot.getId();
	}

	@Override
	public List<Slot> getAllSlotsForPlot(Long plotId) {
		List<com.autoirrigation.entity.Slot> slots = slotRepository.findAllByPlot(plotRepository.getById(plotId));
		return slotMapper.EntityToModel(slots);
	}

	@Override
	public Long configureSlot(Long id, Slot slot) {
		com.autoirrigation.entity.Slot thisSlot = slotRepository.getById(id);
		thisSlot.setAmountOfWater(slot.getAmountOfWater());
		thisSlot.setPeriod(slot.getPeriod());
		thisSlot.setPlot(plotRepository.getById(slot.getPlotId()));
		slotRepository.save(thisSlot);
		return id;
	}

}
