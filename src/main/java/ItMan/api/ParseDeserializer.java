package ItMan.api;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;

public class ParseDeserializer extends StdDeserializer<DateTime> {
    public ParseDeserializer() {
        super(DateTime.class);
    }

    @Override
    public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        return DateTime.parse(p.getValueAsString()); // or overloaded with an appropriate format
    }
}
