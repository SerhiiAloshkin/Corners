package ua.coral.corners.pojo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import ua.coral.corners.config.CornersConfig

@ContextConfiguration(classes = CornersConfig.class)
class DescTest extends Specification {

    @Autowired
    Desc desc;

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

        Chip chip = desc.getCell(0, 2).chip
        desc.getCell(0, 2).chip = desc.getCell(0, 3).chip
        desc.getCell(0, 3).chip = chip

        int blackValue = desc.getBlackValue()
        int whiteValue = desc.getWhiteValue()

        then:

        blackValue == 50
        whiteValue == 0
    }
}
