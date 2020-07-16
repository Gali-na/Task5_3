import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> lines = null;
        List<String> result = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName), UTF_8);
        } catch (IOException e) {
            e.getMessage().toString();
        }
        String[] array = new String[0];
        if (lines != null) {
            int j = 0;
            for (String s : lines) {
                String[] tempString = new String[s.length()];
                tempString = s.split("[.?! ]");
                // int j=0;
                for (int i = 0; i < tempString.length; i++) {
                    String lineLower = new String();
                    lineLower = tempString[i].toLowerCase();
                    if (lineLower.startsWith("w")) {
                        result.add(lineLower);
                        j++;
                    }
                }
            }
            Collections.sort(result);
            array = result.toArray(new String[0]);
        }
        return array;
    }
}