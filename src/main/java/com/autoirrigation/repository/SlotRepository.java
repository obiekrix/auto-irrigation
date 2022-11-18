package com.autoirrigation.repository;

import com.autoirrigation.entity.Plot;
import com.autoirrigation.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

	List<Slot> findAllByPlot(Plot plot);

	@Query("SELECT s FROM Slot s WHERE s.period=:period AND s NOT IN (SELECT r.slot from Request r WHERE r.hour=:period AND r.irrigated=true)")
	List<Slot> findAllSlotsReadyForIrrigation(@Param("period") Integer period);
}
