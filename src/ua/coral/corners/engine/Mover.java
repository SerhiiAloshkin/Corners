package ua.coral.corners.engine;

import ua.coral.corners.pojo.Chip;
import ua.coral.corners.pojo.Coordinates;
import ua.coral.corners.pojo.Desc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mover {

    @Autowired
    private Desc desc;

    public void move(final Coordinates from, final Coordinates to) {
        final Chip chip = desc.getCell(from).getChip();
        desc.setChipToCell(from, desc.getCell(to).getChip());
        desc.setChipToCell(to, chip);
    }
}
