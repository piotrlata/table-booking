package com.example.tablebooking.repository;

import com.example.tablebooking.model.dao.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}
