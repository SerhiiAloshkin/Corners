package ua.coral.corners.service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import ua.coral.corners.config.CornersConfig
import ua.coral.corners.pojo.Coordinates

@ContextConfiguration(classes = CornersConfig.class)
class DescServiceTest extends Specification {

    @Autowired
    DescService descService;
    @Autowired
    MoveService mover;

    def 'should return 0 value for default chip'() {
        when:

        int blackValue = descService.getBlackValue()
        int whiteValue = descService.getWhiteValue()

        then:

        blackValue == 0
        whiteValue == 0
    }

    def 'should return value for moved chip'() {
        when:

        mover.move(new Coordinates(0, 2), new Coordinates(0, 3))
        mover.move(new Coordinates(5, 5), new Coordinates(5, 4))

        int blackValue = descService.getBlackValue()
        int whiteValue = descService.getWhiteValue()

        then:

        blackValue == 50
        whiteValue == 70
    }
}
