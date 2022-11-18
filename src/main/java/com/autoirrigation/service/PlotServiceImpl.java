package com.autoirrigation.service;

import com.autoirrigation.mapper.PlotMapper;
import com.autoirrigation.model.IrrigationRequest;
import com.autoirrigation.model.Plot;
import com.autoirrigation.model.Slot;
import com.autoirrigation.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {

	private final PlotRepository plotRepository;
	private final PlotMapper plotMapper;

	@Autowired
	public PlotServiceImpl(PlotRepository plotRepository, PlotMapper plotMapper){
		this.plotRepository = plotRepository;
		this.plotMapper = plotMapper;
	}

	@Override
	public void addPlot(Plot plot) {
		plotRepository.save(plotMapper.modelToEntity(plot));
	}

	@Override
	public List<Plot> getAllPlots() {
		return plotMapper.EntityToModel(plotRepository.findAll());
	}

	@Override
	public Long updatePlot(Long id, String name) {
		com.autoirrigation.entity.Plot plot = plotRepository.getById(id);
		plot.setName(name);
		plotRepository.saveAndFlush(plot);
		return plot.getId();
	}
}
