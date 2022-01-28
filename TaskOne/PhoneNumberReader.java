package TaskOne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberReader {
    private FileInputStream fis;
    private String pathToFile;

    public void setPathToFile(String nameOfFile) {
        this.pathToFile = nameOfFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public List<String> readAllLines() {
        List<String> bufferArray = new ArrayList<String>();
        try {
            fis = new FileInputStream((getPathToFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPathToFile()))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                bufferArray.add(line);
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
        return bufferArray;
    }

//    public boolean isPhoneNumberOk(String data) {
//        String dataWithoutSpaces = data.replace(" ", "");
//        return dataWithoutSpaces.length() > 10;
//    }

    public boolean isPhoneNumberValid(String data) {
        //987-123-4567
        Pattern patternOne = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        //(123) 456-7890
        Pattern patternTwo = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

        Matcher matcherOne = patternOne.matcher(data);
        Matcher matcherTwo = patternTwo.matcher(data);

        return matcherOne.matches() || matcherTwo.matches();
    }


    public void printAllPhoneNumber() {
        List<String> listOfPhoneNumbers = readAllLines();
        for (int i = 0; i < listOfPhoneNumbers.size(); i++) {
            if (isPhoneNumberValid(readAllLines().get(i))) {
                System.out.println(readAllLines().get(i));
            }
        }
    }
}


class PhoneNumberReaderTest {
    public static void main(String[] args) {
        PhoneNumberReader reader = new PhoneNumberReader();
        reader.setPathToFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskOne\\file.txt");
        reader.printAllPhoneNumber();
    }

}