package ua.coral.corners.controller;

import ua.coral.corners.pojo.Cell;
import ua.coral.corners.pojo.Coordinates;
import ua.coral.corners.pojo.Desc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @Autowired
    Desc desc;

    @RequestMapping(value = "/", method = GET)
    public Map<Coordinates, Cell> cells() {
        return desc.getCells();
    }
}
