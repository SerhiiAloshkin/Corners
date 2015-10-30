package ua.coral.corners.service;

import ua.coral.corners.pojo.Chip;
import ua.coral.corners.pojo.Coordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveService {

    @Autowired
    private DescService descService;

    public void move(final Coordinates from, final Coordinates to) {
        final Chip chip = descService.getCell(from).getChip();
        descService.setChipToCell(from, descService.getCell(to).getChip());
        descService.setChipToCell(to, chip);
    }
}
