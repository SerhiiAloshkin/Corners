package ua.coral.corners.service;

import ua.coral.corners.pojo.Cell;
import ua.coral.corners.pojo.Chip;
import ua.coral.corners.pojo.ChipType;
import ua.coral.corners.pojo.Coordinates;
import ua.coral.corners.pojo.Desc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static ua.coral.corners.pojo.ChipType.BLACK;
import static ua.coral.corners.pojo.ChipType.WHITE;

@Component
public class DescService {

    @Autowired
    Desc desc;

    public Cell getCell(final Coordinates coordinates) {
        return desc.getCells().get(coordinates);
    }

    public void setChipToCell(final Coordinates coordinates, final Chip chip) {
        desc.getCells().get(coordinates).setChip(chip);
    }

    public int getBlackValue() {
        return getValue(BLACK);
    }

    public int getWhiteValue() {
        return getValue(WHITE);
    }

    public boolean isEmptyCell(final Coordinates coordinates) {
        if (desc.getCells().containsKey(coordinates)) {
            return desc.getCells().get(coordinates).isEmpty();
        }
        return false;
    }

    private int getValue(final ChipType chipType) {
        int value = 0;
        for (final Map.Entry<Coordinates, Cell> entry : desc.getCells().entrySet()) {
            final Cell cell = entry.getValue();
            final Chip chip = cell.getChip();
            if (chip.getChipType() == chipType) {
                value += cell.getCellValue().getValue(chipType);
            }
        }
        return value;
    }
}
