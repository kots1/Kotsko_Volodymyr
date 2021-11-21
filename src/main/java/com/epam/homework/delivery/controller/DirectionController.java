package com.epam.homework.delivery.controller;

import com.epam.homework.delivery.dto.DirectionDto;
import com.epam.homework.delivery.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DirectionController {
    final DirectionService directionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/direction")
    public List<DirectionDto> getDirections() {
        return directionService.getAllDirection();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/direction")
    public DirectionDto createDirection(@RequestBody @Valid DirectionDto directionDto) {
        return directionService.createDirection(directionDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/direction/{id}")
    public DirectionDto getDirectionById(@PathVariable int id) {
        return directionService.getDirectionByID(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/direction/{id}")
    public void delete(@PathVariable int id) {
        directionService.deleteDirection(id);
    }
}
