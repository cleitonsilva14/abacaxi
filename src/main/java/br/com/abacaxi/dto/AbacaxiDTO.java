package br.com.abacaxi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AbacaxiDTO (@NotBlank String name, @NotNull Float price, @NotBlank String origin ){

}
