import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


public class JsonUsage {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
			InputStream input = new FileInputStream("src/employers.json");
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			TypeFactory typeFactory = TypeFactory.defaultInstance();
			List<Employers> employers = objectMapper.readValue(input, 
					typeFactory.constructCollectionType(ArrayList.class, Employers.class));

			System.out.println(employers);
	}

}
