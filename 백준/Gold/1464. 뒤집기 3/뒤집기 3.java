import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String dictFront = String.valueOf(line.charAt(0));
        char headChar = line.charAt(0);

        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c <= headChar) {
                headChar = c;
                dictFront = c + dictFront;
            }
            else {
                dictFront = dictFront + c;
            }
        }
        System.out.println(dictFront);
    }
}