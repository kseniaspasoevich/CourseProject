package Service2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;

import static Service2.GlobalArrayList.List1;

public class ToJSON {
    public static void serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List1);
        objectWriter.writeValue(Paths.get("timeTable.json").toFile(), List1);
    }
}
