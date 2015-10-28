package ua.coral.corners.pojo;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(hIndex, that.hIndex) &&
                Objects.equals(vIndex, that.vIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hIndex, vIndex);
    }
}
