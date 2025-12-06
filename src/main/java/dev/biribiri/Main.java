package dev.biribiri;

import java.io.IOException;

public class Main {
    static void main() {
        try {
            Day1.run("src/main/resources/input-day-1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
