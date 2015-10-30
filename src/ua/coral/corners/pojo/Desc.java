package ua.coral.corners.pojo;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Desc {

    private final Map<Coordinates, Cell> cells;

    public Desc(final Map<Coordinates, Cell> cells) {
        this.cells = cells;
    }

    public Map<Coordinates, Cell> getCells() {
        return cells;
    }
}
