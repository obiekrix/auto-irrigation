package com.autoirrigation.service;

import com.autoirrigation.SensorAvailability;
import com.autoirrigation.entity.Plot;
import com.autoirrigation.entity.Request;
import com.autoirrigation.entity.Slot;
import com.autoirrigation.model.IrrigationRequest;
import com.autoirrigation.repository.PlotRepository;
import com.autoirrigation.repository.RequestRepository;
import com.autoirrigation.repository.SlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class RequestServiceImpl implements RequestService {

	Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);

	@Value("${irrigation.request.retry.count}")
	private int retryCount;
	@Value("${irrigation.request.retry.interval}")
	private int retryInterval;

	private final RequestRepository requestRepository;
	private final SlotRepository slotRepository;
	private final PlotRepository plotRepository;

	@Autowired
	public RequestServiceImpl(RequestRepository requestRepository, SlotRepository slotRepository, PlotRepository plotRepository) {
		this.requestRepository = requestRepository;
		this.slotRepository = slotRepository;
		this.plotRepository = plotRepository;
	}

	@Override
	public void saveIrrigationRequest(Request request) {
		requestRepository.save(request);
	}

	@Override
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}

	@Override
	public Integer requestIrrigation() {
		//get the current hour of the day
		int currentHour = LocalDateTime.now().getHour();
		//look for all slot whose period is same as the current hour of the day
		List<com.autoirrigation.entity.Slot> slots = slotRepository.findAllSlotsReadyForIrrigation(currentHour);
		//loop through and send irrigation request
		for (com.autoirrigation.entity.Slot slot : slots) {
			IrrigationRequest irrigationRequest = new IrrigationRequest();
			irrigationRequest.setAmountOfWater(slot.getAmountOfWater());
			irrigationRequest.setPlotId(slot.getPlot().getId());
			irrigationRequest.setSlotId(slot.getId());
			SensorAvailability availability = processIrrigation(irrigationRequest);
			if (availability != SensorAvailability.AVAILABLE) {
				retry(irrigationRequest);
			}
		}
		return slots.size();
	}

	private SensorAvailability processIrrigation(IrrigationRequest irrigationRequest) {
		Random random = new Random();
		int randomInt = random.nextInt(10);
		Request request = new Request();
		request.setIrrigationTime(LocalDateTime.now());
		request.setHour(LocalDateTime.now().getHour());
		request.setSlot(slotRepository.getById(irrigationRequest.getSlotId()));
		if (randomInt % 3 == 0) {
			request.setIrrigated(false);
			saveIrrigationRequest(request);
			return SensorAvailability.NOT_AVAILABLE;
		}
		request.setIrrigated(true);
		saveIrrigationRequest(request);
		return SensorAvailability.AVAILABLE;
	}

	private void retry(IrrigationRequest irrigationRequest) {
		Plot plot = plotRepository.getById(irrigationRequest.getPlotId());
		Slot slot = slotRepository.getById(irrigationRequest.getSlotId());
		SensorAvailability availability;
		int trials = retryCount;
		while (trials > 0) {
			try {
				Thread.sleep(retryInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			availability = processIrrigation(irrigationRequest);
			trials--;
			log.info("Retry attempt {} for plot: {} on time slot:{}:00 hours", retryCount - trials, plot.getName(), slot.getPeriod());
			if (availability == SensorAvailability.AVAILABLE) {
				return;
			}
		}
		alert("admin@website.com", irrigationRequest);

	}

	private void alert(String admin, IrrigationRequest irrigationRequest) {
		Plot plot = plotRepository.getById(irrigationRequest.getPlotId());
		Slot slot = slotRepository.getById(irrigationRequest.getSlotId());

		log.info("==============ALERT==============");
		log.info("Sensor device is not available to process irrigation request for plot: {} on time slot:{}:00 hours", plot.getName(), slot.getPeriod());

		//TODO send email to admin
		log.info("An alert email has been sent to the admin on {}", admin);
	}

}
