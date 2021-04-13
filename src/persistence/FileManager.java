package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {
    
    FileWriter fileWriter;
    FileReader fileReader;
    BufferedReader bufferedReader;


    public FileManager() {
    }

    /**
     * Se encarga de la lectura de los Doctores
     * @param nameFile nombre del archivo 
     * @return
     * @throws IOException
     */
    public ArrayList<String> readFile(String nameFile) throws IOException{
        ArrayList<String> list = new ArrayList<>();
        File file = new File(nameFile);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        String reading;

        while ((reading = bufferedReader.readLine()) != null){
            list.add(reading);
        }
        bufferedReader.close();
        return list;   
    }

    /**
     * Se encarga de escribr en el archivo 
     * @param nameFile
     * @param line
     * @throws IOException
     */
    public void writeFile(String nameFile, String line) throws IOException {
        File file = new File(nameFile);
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter out = new PrintWriter(fileWriter);
        out.println(line);
        out.close();
        System.out.println("Se ha escrito en el archivo");  
    }
}
