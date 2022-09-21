package com.example.tablebooking.service;

import com.example.tablebooking.model.TableStatus;
import com.example.tablebooking.model.dao.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    RestaurantTable createTable(RestaurantTable restaurantTable);

    void deleteTable(Long id);

    RestaurantTable updateTableStatus(TableStatus tableStatus, Long id);

    RestaurantTable getTable(Long id);

    List<RestaurantTable> getAllTables();
}
