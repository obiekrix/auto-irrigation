package com.autoirrigation.service;

import com.autoirrigation.model.IrrigationRequest;
import com.autoirrigation.model.Plot;
import com.autoirrigation.model.Slot;

import java.util.List;

public interface PlotService {

	void addPlot(Plot ideaSGroupBlockDetail);

	List<Plot> getAllPlots();

	Long updatePlot(Long id, String name);
}
