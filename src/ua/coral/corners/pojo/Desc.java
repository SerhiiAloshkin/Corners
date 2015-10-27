package ua.coral.corners.pojo;

import java.util.Map;

import org.springframework.stereotype.Component;

import static ua.coral.corners.engine.Values.BLACK_VALUES;
import static ua.coral.corners.engine.Values.WHITE_VALUES;
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

    public int getBlackValue() {
        return getValue(BLACK, BLACK_VALUES);
    }

    public int getWhiteValue() {
        return getValue(WHITE, WHITE_VALUES);
    }

    public boolean isEmptyCell(final Coordinates coordinates) {
        if (cellMap.containsKey(coordinates)) {
            return cellMap.get(coordinates).isEmpty();
        }
        return false;
    }

    private int getValue(final ChipType chipType, final int[][] values) {
        int value = 0;
        for (final Map.Entry<Coordinates, Cell> entry : cellMap.entrySet()) {
            final Coordinates coordinates = entry.getKey();
            final Chip chip = entry.getValue().getChip();
            if (chip.getChipType() == chipType) {
                value += values[coordinates.getHIndex()][coordinates.getVIndex()];
            }
        }
        return value;
    }
}
