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


public class JsonTable<T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {    	
        this.filepath = filepath;        	
    }

    public static<T> JsonReader readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        T read = null;
        try {
            final JsonReader a = new JsonReader(new FileReader(filepath));
            read = gson.fromJson(a, clazz);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return (JsonReader) read;
    }

    public void writeJson() throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException {
        try{
            FileWriter writer = new FileWriter(filepath);
            String json = gson.toJson(object);
            writer.write(json);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

/*public class JsonTable <T> extends Vector{
	public final String filepath = "";
	private static final Gson gson = new Gson();
	
	public JsonTable(Class<T> clazz, String filepath) throws IOException{
		this.filepath = filepath;
	}
	
	public static <T> T readJson (Class <T> clazz, String filepath) throws FileNotFoundException{
		final JsonReader a = new JsonReader(new FileReader(filepath));
		return gson.fromJson(a, clazz);
	}
	
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
	
	public static void writeJson (Object object, String filepath) throws IOException{
		final FileWriter writer=new FileWriter(filepath);
		writer.write(gson.toJson(object));
	}
	
	*/
	

