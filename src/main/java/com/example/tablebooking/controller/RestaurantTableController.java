package com.example.tablebooking.controller;

import com.example.tablebooking.mapper.RestaurantTableMapper;
import com.example.tablebooking.model.TableStatus;
import com.example.tablebooking.model.dto.RestaurantTableDto;
import com.example.tablebooking.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tables")
public class RestaurantTableController {
    private final RestaurantTableService restaurantTableService;
    private final RestaurantTableMapper restaurantTableMapper;

    @PostMapping
    @PreAuthorize("isAuthenticated() && hasAuthority('SCOPE_ADMIN')")
    @Operation(description = "add new table", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public RestaurantTableDto createTable(@RequestBody RestaurantTableDto restaurantTableDto) {
        return restaurantTableMapper.daoToDto(restaurantTableService
                .createTable(restaurantTableMapper.dtoToDao(restaurantTableDto)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasAuthority('SCOPE_ADMIN')")
    @Operation(description = "delete table", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public void deleteTable(@PathVariable Long id) {
        restaurantTableService.deleteTable(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasAuthority('SCOPE_ADMIN')")
    @Operation(description = "update status of the table", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public RestaurantTableDto updateTableStatus(@RequestBody TableStatus tableStatus, @PathVariable Long id) {
        return restaurantTableMapper.daoToDto(restaurantTableService.updateTableStatus(tableStatus, id));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasAuthority('SCOPE_ADMIN')")
    @Operation(description = "get table details", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public RestaurantTableDto getTable(@PathVariable Long id) {
        return restaurantTableMapper.daoToDto(restaurantTableService.getTable(id));
    }

    @GetMapping
    @PreAuthorize("isAnonymous()")
    @Operation(description = "get all tables", security = {@SecurityRequirement(name = "bearer"),
            @SecurityRequirement(name = "basicAuth")})
    public List<RestaurantTableDto> getAllTables() {
        return restaurantTableMapper.listDaoToListDto(restaurantTableService.getAllTables());
    }
}