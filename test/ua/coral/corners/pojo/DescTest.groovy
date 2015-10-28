package ua.coral.corners.pojo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import ua.coral.corners.config.CornersConfig
import ua.coral.corners.engine.Mover

@ContextConfiguration(classes = CornersConfig.class)
class DescTest extends Specification {

    @Autowired
    Desc desc;
    @Autowired
    Mover mover;

    def 'should return 0 value for default chip'() {
        when:

        int blackValue = desc.getBlackValue()
        int whiteValue = desc.getWhiteValue()

        then:

        blackValue == 0
        whiteValue == 0
    }

    def 'should return value for moved chip'() {
        when:

        mover.move(new Coordinates(0, 2), new Coordinates(0, 3))
        mover.move(new Coordinates(5, 5), new Coordinates(5, 4))

        int blackValue = desc.getBlackValue()
        int whiteValue = desc.getWhiteValue()

        then:

        blackValue == 50
        whiteValue == 70
    }
}
