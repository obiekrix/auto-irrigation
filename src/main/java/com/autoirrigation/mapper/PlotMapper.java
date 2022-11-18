package com.autoirrigation.mapper;

import com.autoirrigation.entity.Plot;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlotMapper {

    Plot modelToEntity(com.autoirrigation.model.Plot plot);
	com.autoirrigation.model.Plot EntityToModel(Plot plot);

    List<Plot> modelToEntity(List<com.autoirrigation.model.Plot> plots);
    List<com.autoirrigation.model.Plot> EntityToModel(List<Plot> plots);
}
