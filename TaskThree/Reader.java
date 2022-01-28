package TaskThree;

import java.io.*;
import java.util.*;

public class Reader {

    private FileInputStream fis;
    private String pathToFile;

    public void setPathToFile(String nameOfFile) {
        this.pathToFile = nameOfFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String readAllLines() {
        String result = "";
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream((getPathToFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPathToFile()))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                sb.append(line + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result = sb + "";
    }

    public List<String> toArrayList() {
        List<String> arrayOfWords = Arrays.asList(readAllLines().split(" "));
        return arrayOfWords;
    }

    public void countWords() {

        String str = readAllLines();
        HashSet<String> hList = new HashSet<String>(toArrayList());
        List<String> arrList = new ArrayList<String>(hList);
        List<String> result = new ArrayList<String>();
        int count = 0;
        for (String value : arrList) {
            if (str.contains(value)) {
                count++;
                result.add(value + " " + count);
            }
        }
        Collections.reverse(result);


        for (String s : result) {
            System.out.println(s);
        }
    }
}

class ReaderTester {

    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.setPathToFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskThree\\words.txt");
        reader.countWords();

    }
}

