package MarcellaJmartKD;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (13/11/2021)
 */

public class JsonTable<T> extends Vector<T>{
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] reader = readJson(arrayType, filepath);
            if(reader != null) {
                Collections.addAll(this, reader);
            }
        } catch (FileNotFoundException e) {
            File files = new File(filepath);
            File files_new = files.getParentFile();
            if(files_new != null) {
                files.mkdir();
            }
            files.createNewFile();
        }
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        Reader reader = new FileReader(filepath);
        return gson.fromJson(reader, clazz);
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }
}

	

