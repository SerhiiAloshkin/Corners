package ua.coral.corners.pojo;

import org.springframework.stereotype.Component;

import static ua.coral.corners.pojo.ChipType.EMPTY;

@Component
public class Cell {

    private Chip chip;
    private final Coordinates coordinates;

    public Cell(final Coordinates coordinates) {
        this.coordinates = coordinates;
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

    public boolean isEmpty() {
        return chip.getChipType() == EMPTY;
    }
}
