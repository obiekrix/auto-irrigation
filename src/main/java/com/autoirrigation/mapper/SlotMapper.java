package com.autoirrigation.mapper;

import com.autoirrigation.entity.Slot;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SlotMapper {

    Slot modelToEntity(com.autoirrigation.model.Slot slot);
	com.autoirrigation.model.Plot EntityToModel(Slot slot);

    List<Slot> modelToEntity(List<com.autoirrigation.model.Slot> slots);
    List<com.autoirrigation.model.Slot> EntityToModel(List<Slot> slots);
}
