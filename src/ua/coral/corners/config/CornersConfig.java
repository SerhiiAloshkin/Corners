package ua.coral.corners.config;

import ua.coral.corners.pojo.Cell;
import ua.coral.corners.pojo.Chip;
import ua.coral.corners.pojo.ChipType;
import ua.coral.corners.pojo.Coordinates;
import ua.coral.corners.pojo.Desc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static ua.coral.corners.engine.Constants.MAX_LENGTH;
import static ua.coral.corners.pojo.ChipType.BLACK;
import static ua.coral.corners.pojo.ChipType.EMPTY;
import static ua.coral.corners.pojo.ChipType.WHITE;

@Configuration
public class CornersConfig {

    @Bean
    public Desc getDesc() {
        final Map<Coordinates, Cell> cells = new LinkedHashMap<>();
        for (int v = 0; v < MAX_LENGTH; v++) {
            for (int h = 0; h < MAX_LENGTH; h++) {
                cells.put(Coordinates.getObject(h, v), getCell(h, v));
            }
        }
        return new Desc(cells);
    }

    @Bean
    @Scope("prototype")
    public Cell getCell(final int hIndex, final int vIndex) {
        final Cell cell = new Cell(getCoordinates(hIndex, vIndex));
        cell.setChip(getChip(hIndex, vIndex));
        return cell;
    }

    @Bean
    @Scope("prototype")
    public Chip getChip(final int hIndex, final int vIndex) {
        return new Chip(createChipByIndex(hIndex, vIndex));
    }

    @Bean
    @Scope("prototype")
    public Coordinates getCoordinates(final int hIndex, final int vIndex) {
        return Coordinates.getObject(hIndex, vIndex);
    }

    private ChipType createChipByIndex(final int hIndex, final int vIndex) {
        if (hIndex < 3 && vIndex < 3) {
            return BLACK;
        } else if (hIndex > 4 && vIndex > 4) {
            return WHITE;
        }
        return EMPTY;
    }
}
