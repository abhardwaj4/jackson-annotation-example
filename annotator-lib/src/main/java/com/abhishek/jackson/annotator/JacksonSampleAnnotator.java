package com.abhishek.jackson.annotator;

import com.abhishek.jackson.annotation.SkipSerialize;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

/**
 *
 * @author Abhishek Bhardwaj
 */
public class JacksonSampleAnnotator extends AbstractAnnotator {
    
    public static final String SKIP_SERIALIZE_FILTER = "skipSerializeFilter";
    
    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
       super.propertyField(field, clazz, propertyName, propertyNode);
       
       if ( propertyNode.has( "skipSerialize" ) && true == propertyNode.get( "skipSerialize" ).asBoolean() ) {
           // annotate with SkipSerialize only if the schema defines it
           field.annotate( SkipSerialize.class );
       }
    }
    
    @Override
    public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
        super.propertyInclusion(clazz, schema);
        
        // need this annotation on the POJO for D3LogFilter to kick in
        clazz.annotate( JsonFilter.class ).param( "value", SKIP_SERIALIZE_FILTER );
    }
}
