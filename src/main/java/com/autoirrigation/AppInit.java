package com.autoirrigation;

import com.autoirrigation.entity.Plot;
import com.autoirrigation.entity.Slot;
import com.autoirrigation.repository.PlotRepository;
import com.autoirrigation.repository.SlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@ApplicationScope
@Component
public class AppInit implements ApplicationListener<ApplicationStartedEvent> {

	Logger log = LoggerFactory.getLogger(AppInit.class);

	private final PlotRepository plotRepository;
	private final SlotRepository slotRepository;

	public AppInit(PlotRepository plotRepository, SlotRepository slotRepository) {
		this.plotRepository = plotRepository;
		this.slotRepository = slotRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		log.info("Seeding database data");
	}

	@PostConstruct
	private void init() {
		Plot plot = new Plot();
		plot.setName("Rice Plot");
		plot.setSoilMoistureLevel(BigDecimal.valueOf(20));
		plotRepository.save(plot);

		Slot slot = new Slot();

		slot.setPlot(plot);
		slot.setAmountOfWater(100);
		slot.setPeriod(17);
		slotRepository.save(slot);
		slot = new Slot();
		slot.setPlot(plot);
		slot.setAmountOfWater(200);
		slot.setPeriod(12);
		slotRepository.save(slot);
		slot = new Slot();
		slot.setPlot(plot);
		slot.setAmountOfWater(300);
		slot.setPeriod(2);
		slotRepository.save(slot);

		plot = new Plot();
		plot.setName("Maize Plot");
		plot.setSoilMoistureLevel(BigDecimal.valueOf(10));
		plotRepository.save(plot);

		slot = new Slot();
		slot.setPlot(plot);
		slot.setAmountOfWater(130);
		slot.setPeriod(13);
		slotRepository.save(slot);
		slot = new Slot();
		slot.setPlot(plot);
		slot.setAmountOfWater(240);
		slot.setPeriod(17);
		slotRepository.save(slot);
	}

}
