package TaskTwoViaGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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



    public List<Object> getBenchOfData(){
        List<Object> personalData = new ArrayList<Object>();


        for (int i = 0 ;  i < readAllLines().size(); i++){
           List<String> arrayFromLine = Arrays.asList(readAllLines().get(i).split(" "));
           personalData.add(new Person(arrayFromLine.get(0), arrayFromLine.get(1)));
       }
        personalData.remove(0);
        return personalData;
    }


    public void saverDataInFile() {
        file = new File(getPathToNewFile());
        fw = null;
        Gson conv = new GsonBuilder().setPrettyPrinting().create();
        String str =  conv.toJson(getBenchOfData());
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

class Person{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    Person(String name, String age){
        this.name = name;
        this.age = age;
    }
}

class ReaderDataTester {
    public static void main(String[] args) {
        ReaderData reader = new ReaderData();
        reader.setPathToFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskTwoViaGson\\file.txt");
        reader.setPathToNewFile("C:\\Java\\jm\\ReaderSaver\\src\\main\\java\\TaskTwoViaGson\\user.json");
        reader.saverDataInFile();


    }

}
