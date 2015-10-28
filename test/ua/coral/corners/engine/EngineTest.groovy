package ua.coral.corners.engine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import ua.coral.corners.config.CornersConfig
import ua.coral.corners.pojo.Coordinates
import ua.coral.corners.pojo.Desc

@ContextConfiguration(classes = CornersConfig.class)
class EngineTest extends Specification {

    @Autowired
    Desc desc;

    def 'should allow to do next step'() {
        given:

        Engine engine = new Engine(desc)

        expect:

        engine.canNextStep(new Coordinates(hIndex, vIndex)) == result

        where:

        hIndex | vIndex | result
        0      | 0      | false
        0      | 1      | true
        0      | 2      | true
        1      | 0      | true
        1      | 1      | true
        1      | 2      | true
        2      | 0      | true
        2      | 1      | true
        2      | 2      | true
        7      | 7      | false
        7      | 6      | true
        7      | 5      | true
        6      | 7      | true
        6      | 6      | true
        6      | 5      | true
        5      | 7      | true
        5      | 6      | true
        5      | 5      | true
    }
}
