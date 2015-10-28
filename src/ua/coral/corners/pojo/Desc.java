package ua.coral.corners.pojo;

import java.util.Map;

import org.springframework.stereotype.Component;

import static ua.coral.corners.pojo.ChipType.BLACK;
import static ua.coral.corners.pojo.ChipType.WHITE;

@Component
public class Desc {

    private final Map<Coordinates, Cell> cellMap;

    public Desc(final Map<Coordinates, Cell> cellMap) {
        this.cellMap = cellMap;
    }

    public Cell getCell(final Coordinates coordinates) {
        return cellMap.get(coordinates);
    }

    public void setChipToCell(final Coordinates coordinates, final Chip chip) {
        cellMap.get(coordinates).setChip(chip);
    }

    public int getBlackValue() {
        return getValue(BLACK);
    }

    public int getWhiteValue() {
        return getValue(WHITE);
    }

    public boolean isEmptyCell(final Coordinates coordinates) {
        if (cellMap.containsKey(coordinates)) {
            return cellMap.get(coordinates).isEmpty();
        }
        return false;
    }

    private int getValue(final ChipType chipType) {
        int value = 0;
        for (final Map.Entry<Coordinates, Cell> entry : cellMap.entrySet()) {
            final Cell cell = entry.getValue();
            final Chip chip = cell.getChip();
            if (chip.getChipType() == chipType) {
                value += cell.getCellValue().getValue(chipType);
            }
        }
        return value;
    }
}
