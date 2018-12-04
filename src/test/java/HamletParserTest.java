import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {

    private HamletParser hamletParser;
    private String hamletText;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.toLeon();
        Assert.assertFalse(hamletParser.findHamlet());
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.toTariq();
        Assert.assertFalse(hamletParser.findHoratio());
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio());
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet());
    }
}