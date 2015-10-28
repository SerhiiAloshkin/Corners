package ua.coral.corners.pojo;

import org.springframework.stereotype.Component;

import static ua.coral.corners.pojo.ChipType.EMPTY;

@Component
public class Cell {

    private Chip chip;
    private final Coordinates coordinates;
    private final CellValue cellValue;

    public Cell(final Coordinates coordinates, final CellValue cellValue) {
        this.coordinates = coordinates;
        this.cellValue = cellValue;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(final Chip chip) {
        this.chip = chip;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public CellValue getCellValue() {
        return cellValue;
    }

    public boolean isEmpty() {
        return chip.getChipType() == EMPTY;
    }
}
