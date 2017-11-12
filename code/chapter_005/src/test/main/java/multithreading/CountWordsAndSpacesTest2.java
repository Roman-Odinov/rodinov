package multithreading;

import java.io.File;

public class CountWordsAndSpacesTest2 {

    public static void main(String[] args) {
        File file = new File("chapter_005/src/main/resources/ltols_wojnaimir.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println("START");

        new Thread(new CountWordsAndSpaces(absolutePath, "words")).start();
        new Thread(new CountWordsAndSpaces(absolutePath, "spaces")).start();

    }

}