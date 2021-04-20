package Service3;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FromJSON {
    static void deserialize() throws IOException {
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonFactory jf=new JsonFactory();
            JsonParser jp = jf.createParser(new File("timeTable.json"));
            List<AdditionalParameters> lst=null;

            TypeReference<List<AdditionalParameters>> tRef = new TypeReference<List<AdditionalParameters>>() {};
            lst = objectMapper.readValue(jp, tRef);
            for (AdditionalParameters user : lst) {
                System.out.println(user.toString());
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
