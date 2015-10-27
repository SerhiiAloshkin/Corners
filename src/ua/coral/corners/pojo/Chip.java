package ua.coral.corners.pojo;

import org.springframework.stereotype.Component;

@Component
public class Chip {

    private final ChipType chipType;

    public Chip(final ChipType chipType) {
        this.chipType = chipType;
    }

    public ChipType getChipType() {
        return chipType;
    }
}
