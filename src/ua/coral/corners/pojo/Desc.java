package ua.coral.corners.pojo;

import org.springframework.stereotype.Component;

import static ua.coral.corners.engine.Constants.MAX_LENGTH;
import static ua.coral.corners.engine.Values.BLACK_VALUES;
import static ua.coral.corners.engine.Values.WHITE_VALUES;
import static ua.coral.corners.pojo.ChipType.BLACK;
import static ua.coral.corners.pojo.ChipType.WHITE;

@Component
public class Desc {

    private final Cell[][] cells;

    public Desc(final Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getCell(final int hIndex, final int vIndex) {
        if (hIndex < 0 || vIndex < 0 || hIndex >= MAX_LENGTH || vIndex >= MAX_LENGTH) {
            return null;
        }
        return cells[hIndex][vIndex];
    }

    public int getBlackValue() {
        return getValue(BLACK, BLACK_VALUES);
    }

    public int getWhiteValue() {
        return getValue(WHITE, WHITE_VALUES);
    }

    private int getValue(final ChipType chipType, final int[][] values) {
        int value = 0;
        for (int v = 0; v < MAX_LENGTH; v++) {
            for (int h = 0; h < MAX_LENGTH; h++) {
                if (cells[h][v].getChip().getChipType() == chipType) {
                    value += values[h][v];
                }
            }
        }
        return value;
    }
}
