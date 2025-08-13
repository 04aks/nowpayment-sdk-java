package io.github.aks.nowpayment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {

    private final ObjectMapper mapper;
    public JsonSerializer(){
        this.mapper = new ObjectMapper();
    }

    public String toJson(Object obj){
        try{
            return  mapper.writeValueAsString(obj);
        }catch(JsonProcessingException e){
            throw new RuntimeException("failed to serialize object to json", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz){
        try{
            return mapper.readValue(json, clazz);
        }catch(JsonProcessingException e){
            throw new RuntimeException("failed to deserialize json to object", e);
        }
    }
}
