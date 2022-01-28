package TaskOne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public boolean isPhoneNumberOk(String data) {
        String dataWithoutSpaces = data.replace(" ", "");
        return dataWithoutSpaces.length() > 10;
    }

    public void printAllPhoneNumber() {
        List<String> listOfPhoneNumbers = readAllLines();
        for (int i = 0; i < listOfPhoneNumbers.size(); i++) {
            if (isPhoneNumberOk(readAllLines().get(i))) {
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