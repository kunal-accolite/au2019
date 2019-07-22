package au;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility{
	public static<O> String convertToJSON(O o) {
		String js = null;

		ObjectMapper mp = new ObjectMapper();
		try {
			js = mp.writeValueAsString(o);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		return (js);
	}
	
}