package com.example.tablebooking.model.dto;

import com.example.tablebooking.model.TableStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantTableDto {
    private Long id;
    @NotBlank
    private Byte numberOfSeats;
    private TableStatus tableStatus;
}
