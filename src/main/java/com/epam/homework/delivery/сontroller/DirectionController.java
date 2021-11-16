package com.epam.homework.delivery.сontroller;

import com.epam.homework.delivery.service.DirectionService;
import com.epam.homework.delivery.сontroller.dto.DirectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public DirectionDto createDirection(@RequestBody DirectionDto directionDto) {
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
