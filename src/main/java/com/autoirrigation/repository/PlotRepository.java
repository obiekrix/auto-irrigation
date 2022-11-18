package com.autoirrigation.repository;

import com.autoirrigation.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

	List<Plot> findAll();
}
