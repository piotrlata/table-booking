package com.example.tablebooking.service.impl;

import com.example.tablebooking.model.TableStatus;
import com.example.tablebooking.model.dao.RestaurantTable;
import com.example.tablebooking.repository.RestaurantTableRepository;
import com.example.tablebooking.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {
    private final RestaurantTableRepository restaurantTableRepository;

    @Override
    public RestaurantTable createTable(RestaurantTable restaurantTable) {
        restaurantTable.setTableStatus(TableStatus.AVAILABLE);
        return restaurantTableRepository.save(restaurantTable);
    }

    @Override
    public void deleteTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RestaurantTable updateTableStatus(TableStatus tableStatus, Long id) {
        RestaurantTable tableDb = getTable(id);
        tableDb.setTableStatus(tableStatus);
        return tableDb;
    }

    @Override
    public RestaurantTable getTable(Long id) {
        return restaurantTableRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<RestaurantTable> getAllTables() {
        return restaurantTableRepository.findAll();
    }
}
