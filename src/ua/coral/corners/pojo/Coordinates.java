package ua.coral.corners.pojo;

import org.springframework.stereotype.Component;

@Component
public class Coordinates {

    private final int hIndex;
    private final int vIndex;

    public Coordinates(final int hIndex, final int vIndex) {
        this.hIndex = hIndex;
        this.vIndex = vIndex;
    }

    public int getHIndex() {
        return hIndex;
    }

    public int getVIndex() {
        return vIndex;
    }
}
