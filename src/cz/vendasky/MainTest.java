package cz.vendasky;

import org.junit.Test;

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

}