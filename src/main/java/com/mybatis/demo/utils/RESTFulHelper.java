package com.mybatis.demo.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RESTFulHelper {

	private final static Gson gson = new GsonBuilder().create();
	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	/*public final static Object makeObjectFromJson(Object t){
		return gson.fromJson("{}", t.getClass());
	}*/
	
	public final static String getJsonLikeString(Object obj) throws JsonProcessingException{
	     return objectMapper.writeValueAsString(obj);
	}
	
	public final static String getISOTimeStamp(Date ts) throws RuntimeException {
	    String pattern = "yyyy-mm-dd'T'hh:mm:ss.SSS'Z'";
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	    String isoTS = sdf.format(ts);

	    return isoTS;
	}
	
}
