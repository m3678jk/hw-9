package TaskTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderData {

    private FileInputStream fis;
    private String pathToFile;
    FileWriter fw;
    private String pathToNewFile;
    File file;

    public void setPathToFile(String nameOfFile) {
        this.pathToFile = nameOfFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToNewFile(String pathToNewFile) {
        this.pathToNewFile = pathToNewFile;
    }

    public String getPathToNewFile() {
        return pathToNewFile;
    }

    public List<String> readAllLines() {
        List<String> bufferArrayWithData = new ArrayList<String>();
        try {
            fis = new FileInputStream((getPathToFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPathToFile()))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                bufferArrayWithData.add(line);
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
        return bufferArrayWithData;
    }

    public String readAllLinesToString() {
        StringBuilder sb = new StringBuilder();
        String result = "";
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
        return result + sb;
    }

    public List<String> toList() {

        return Arrays.asList(readAllLinesToString().split(" "));
    }

    public String converter() {
        String resultJson = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < toList().size(); i++) {
            if (i % 2 == 0) {
                sb.append("\t{\n\t\t\"").append(toList().get(0)).append("\": ");
                sb.append("\"").append(toList().get(i)).append("\",\n");
            } else if (i != toList().size() - 1) {
                sb.append("\t\t\"").append(toList().get(1)).append("\": ");
                sb.append(toList().get(i)).append("\n\t}, \n");
            } else {
                sb.append("\t\t\"").append(toList().get(1)).append("\": ");
                sb.append(toList().get(i)).append("\n\t} \n");
            }


        }
        return resultJson = "[\n" + sb + "\n]";
    }


    public void saverDataInFile() {
        file = new File(getPathToNewFile());
        fw = null;
        String str = converter();
        try {
            fw = new FileWriter(file, true);
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


class ReaderDataTester {
    public static void main(String[] args) {
        ReaderData reader = new ReaderData();
        reader.setPathToFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskTwo\\file.txt");
        reader.setPathToNewFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskTwo\\user.json");
//        System.out.println(reader.readAllLinesToString());
//        System.out.println(reader.toList());
        System.out.println(reader.converter());
        reader.saverDataInFile();


    }

}
