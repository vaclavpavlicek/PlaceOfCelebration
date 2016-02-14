package cz.vendasky;

/**
 * Created by vaclav on 14.2.16.
 */
public class Main {

    public static int returnIdealPositionOfHall(int firstHousePosition, int lastHousePosition) {
        int distance = lastHousePosition - firstHousePosition;
        distance = (distance % 2 == 0)? distance : distance - 1;
        return distance / 2 + firstHousePosition;
    }

}
