package cn.ybzy.mvcproject.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;

public class Record extends LinkedHashMap<String,Object> {
    public void set(String field,Object value){
        put(field,value);
    }
    public String getString(String field){
        return (String)get(field);
    }
    public Integer getInteger(String field){
        return (Integer)get(field);
    }
    public Long getLong(String field){
        return (Long)get(field);
    }
    public BigDecimal getBigDecimal(String field){
        return (BigDecimal)get(field);
    }
    public Date getDate(String field){
        return (Date)get(field);
    }
    public Boolean getBoolean(String field){
        return (Boolean) get(field);
    }
}


