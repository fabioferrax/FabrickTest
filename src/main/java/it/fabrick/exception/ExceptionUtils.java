package it.fabrick.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import it.fabrick.rest.DTO.Error;

@Component
@Configuration
public class ExceptionUtils {

	private static final String EXCEPTION_LIST_SEPARATOR = ";";

	private Map<String,String> exceptionMap;

	@Value("${exceptionMap}")
	private String exceptionMapString;

	public Error convertError(String code, String msg) {
		Error err = new Error();
		err.setCode(code);
		err.setMessage(msg);
		if(code != null && exceptionMap().containsKey(code)) {
			err.setMessage(exceptionMap().get(code));
		}
		return err;
	}
	
	private  Map<String,String> exceptionMap(){
		if(exceptionMap != null) {
			return exceptionMap;
		}
		
		Map<String,String> result = new HashMap<String,String>();
		
		if(exceptionMapString != null) {
			List<String> arrayMap = Arrays.asList(exceptionMapString.split(EXCEPTION_LIST_SEPARATOR));
			String[] key_value;
			for(String keyValue: arrayMap) {
				key_value = keyValue.split(":");
				result.put(key_value[0], key_value[1]);
			}
		}
		
		exceptionMap = result;
		
		return result;
		
	}
}
