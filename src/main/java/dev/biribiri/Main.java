package dev.biribiri;

import java.io.IOException;

public class Main {
    static void main() {
        try {
            IO.println("== Day 1 ==");
            Day1.run("src/main/resources/input-day-1");

            IO.println("== Day 2 ==");
            Day2.run("src/main/resources/input-day-2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
