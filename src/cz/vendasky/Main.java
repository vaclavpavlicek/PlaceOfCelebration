package cz.vendasky;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by vaclav on 14.2.16.
 */
public class Main {

    public static int returnIdealPositionOfHall(int firstHousePosition, int lastHousePosition) {
        int distance = lastHousePosition - firstHousePosition;
        distance = (distance % 2 == 0)? distance : distance - 1;
        return distance / 2 + firstHousePosition;
    }

    public static int[] readPositionsOfHouses(String pathToInputFile) {
        int[] result = null;
        String allLines;
        try (Stream<String> lines = Files.lines(Paths.get(pathToInputFile))) {
            allLines = Arrays.toString(lines.toArray());
            result = new int[Integer.parseInt(allLines.substring(1, allLines.indexOf(" ") - 1))];
            allLines = allLines.substring(allLines.indexOf(" ") + 1, allLines.indexOf("]"));
            for (int i = 0; i < result.length - 1; i++) {
                result[i] = Integer.parseInt(allLines.substring(0, allLines.indexOf(" ")));
                allLines = allLines.substring(allLines.indexOf(" ") + 1);
            }
            result[result.length - 1] = Integer.parseInt(allLines.substring(allLines.lastIndexOf(" ") + 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int findFirstHousePosition(int[] housesPositions) {
        int result = Integer.MAX_VALUE;
        for (int number : housesPositions) {
            if (result > number) {
                result = number;
            }
        }
        return result;
    }

    public static int findLastHousePosition(int[] housesPositions) {
        int result = Integer.MIN_VALUE;
        for (int number : housesPositions) {
            if (result < number) {
                result = number;
            }
        }
        return result;
    }

    public static void generateOutputFile(String pathToOutputFile, int result) {
        try {
            PrintWriter writer = new PrintWriter(pathToOutputFile, "UTF-8");
            writer.println(result);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] housesPosition = readPositionsOfHouses("path to input file");
        int firstHousePosition = findFirstHousePosition(housesPosition);
        int lastHousePosition = findLastHousePosition(housesPosition);
        int idealHallPosition = returnIdealPositionOfHall(firstHousePosition, lastHousePosition);
        generateOutputFile("path to output file", idealHallPosition);
    }

}