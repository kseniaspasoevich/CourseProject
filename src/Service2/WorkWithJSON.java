package Service2;
import Service1.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.FileWriter;
import java.io.IOException;


public class WorkWithJSON {
    public static void main(String[] args) {
        Gson gson = new Gson();
        TimeTable obj=createObject();

        try (FileWriter writer = new FileWriter("C:\\Users\\hp i5\\IdeaProjects\\CourseProject\\file1.json")) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static TimeTable createObject() {
        TimeTable obj=new TimeTable();

        obj.generateName();
        obj.generateDay();
        obj.generateTime();
        return obj;
    }
}
