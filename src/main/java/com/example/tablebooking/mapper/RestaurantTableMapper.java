package com.example.tablebooking.mapper;

import com.example.tablebooking.model.dao.RestaurantTable;
import com.example.tablebooking.model.dto.RestaurantTableDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantTableMapper {
    RestaurantTable dtoToDao(RestaurantTableDto restaurantTableDto);

    RestaurantTableDto daoToDto(RestaurantTable restaurantTable);

    List<RestaurantTableDto> listDaoToListDto(List<RestaurantTable> restaurantTables);
}
