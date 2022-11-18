package com.autoirrigation.rest;

import com.autoirrigation.IrrigationApi;
import com.autoirrigation.model.Plot;
import com.autoirrigation.model.Slot;
import com.autoirrigation.service.PlotService;
import com.autoirrigation.service.RequestService;
import com.autoirrigation.service.SlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IrrigationController implements IrrigationApi {

	private final PlotService plotService;
	private final SlotService slotService;
	private final RequestService requestService;

	public IrrigationController(PlotService plotService, SlotService slotService, RequestService requestService) {
		this.plotService = plotService;
		this.slotService = slotService;
		this.requestService = requestService;
	}

	/**
	 * POST /irrigation/plot/create : Add a new plot of land for irrigation.
	 * In success case, Http Code 202 will be returned.
	 *
	 * @param plot Irrigation Plot to Add (required)
	 * @return Plot successfully created (status code 202)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Void> addPlot(Plot plot) {
		plotService.addPlot(plot);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * POST /irrigation/slot/create : Add a new time slot for the specified plot id.
	 * In success case, Http Code 202 will be returned.
	 *
	 * @param slot Irrigation Plot to Add (required)
	 * @return Time slot successfully created (status code 202)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Void> addSlot(Slot slot) {
		slotService.addSlot(slot);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * PUT /irrigation/slot/configure/id/{id} : Configure the irrigation plan for a plot and time slot.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @param id   The id of the slot to configure (required)
	 * @param slot Configuration details for time slot (required)
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Long> configureSlot(Long id, Slot slot) {
		return ResponseEntity.ok(slotService.configureSlot(id, slot));
	}

	/**
	 * GET /irrigation/plot/list : Get all plots.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<List<Plot>> getAllPlots() {
		return ResponseEntity.ok(plotService.getAllPlots());
	}

	/**
	 * GET /irrigation/slot/id/{plotId}/list : Get all time slot for a specified plot id.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @param plotId The id of the plot to whose time slots we want to query (required)
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<List<Slot>> getAllSlotsForPlot(Long plotId) {
		return ResponseEntity.ok(slotService.getAllSlotsForPlot(plotId));
	}

	/**
	 * DELETE /irrigation/slot/delete/id/{id} : Remove a time slot.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @param id The id of the slot to delete (required)
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Long> removeSlot(Long id) {
		return ResponseEntity.ok(slotService.removeSlot(id));
	}

	/**
	 * POST /irrigation/request : Request for a plot to be irrigated at the clocking of a time slot.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Integer> requestIrrigation() {
		Integer numberOfPlotsIrrigated = requestService.requestIrrigation();
		return ResponseEntity.ok(numberOfPlotsIrrigated);
	}

	/**
	 * PUT /irrigation/plot/update/id/{id}/name/{name}/interval/{irrigationInterval} : Change the plot details such as name and irrigation interval.
	 * In success case, Http Code 200 will be returned.
	 *
	 * @param id                 The id of the plot to update (required)
	 * @param name               The new name for the plot (required)
	 * @return OK (status code 200)
	 * or Bad request (status code 400)
	 * or Internal server error (status code 500)
	 */
	@Override
	public ResponseEntity<Long> updatePlot(Long id, String name) {
		return ResponseEntity.ok(plotService.updatePlot(id, name));
	}

}
