import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
    public static <T> T getRandomElement(List<T> items){
        Random rand = new Random();
        return items.get(rand.nextInt(items.size()));
    }

    public static String shuffleString(String s){
        List<String> letters = Arrays.asList(s.split(""));
        Collections.shuffle(letters);
        StringBuilder shuffled = new StringBuilder();
        for (String letter : letters) {
            shuffled.append(letter);
        }
        return shuffled.toString();
    }

    public static void writeToStream(BufferedWriter stream, String s){
        try {
            stream.write(s + "\n");
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromStream(BufferedReader stream){
        try {
            return stream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
