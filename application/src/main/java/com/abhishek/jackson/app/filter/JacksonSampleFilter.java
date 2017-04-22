package com.abhishek.jackson.app.filter;

import com.abhishek.jackson.annotation.SkipSerialize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

/**
 * This filter's instance is added to Jackson's ObjectMapper builder.
 * This gets invoked during the serialization process of the POJO annotated with
 * @JsonFilter annotation.
 * 
 * @author Abhishek Bhardwaj
 */
public class JacksonSampleFilter extends SimpleBeanPropertyFilter {
    
    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, 
            PropertyWriter writer) throws Exception {
        if ( include(writer) ) {
            if ( writer.getAnnotation(SkipSerialize.class) !=  null ) {
                return;
            }
            writer.serializeAsField( pojo, jgen, provider );
        } else if (!jgen.canOmitFields()) {
            writer.serializeAsOmittedField( pojo, jgen, provider );
        }
    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return true;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return true;
    }
}