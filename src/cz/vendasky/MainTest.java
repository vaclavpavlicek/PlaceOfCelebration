package cz.vendasky;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by vaclav on 14.2.16.
 */
public class MainTest {

    @Test
    public void shouldReturnIdealPositionOfHall() {
        assertEquals(14, Main.returnIdealPositionOfHall(3, 25));
        assertEquals(5, Main.returnIdealPositionOfHall(1, 10));
        assertEquals(6, Main.returnIdealPositionOfHall(2, 10));
    }

    @Test
    public void shouldReadPositionsOfHouses() {
        int[] expectedResult = {3, 5, 17, 24, 25};
        assertArrayEquals(expectedResult, Main.readPositionsOfHouses("/home/vaclav/IdeaProjects/PlaceOfCelebration/inputs/test.txt"));
    }

    @Test
    public void shouldFindFirstHousePosition() {
        assertEquals(3, Main.findFirstHousePosition(Main.readPositionsOfHouses("/home/vaclav/IdeaProjects/PlaceOfCelebration/inputs/test.txt")));
    }
}