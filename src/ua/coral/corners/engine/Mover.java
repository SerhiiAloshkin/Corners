package ua.coral.corners.engine;

import ua.coral.corners.pojo.Coordinates;
import ua.coral.corners.pojo.Desc;

import org.springframework.beans.factory.annotation.Autowired;

public class Mover {

    @Autowired
    private static Desc desc;

    private Mover() {
        super();
    }

    public static void move(final Coordinates from, final Coordinates to) {
        //desc.getCell(from)
    }
}
