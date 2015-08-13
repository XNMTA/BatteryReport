import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.dto.BatteryMessage;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static junit.framework.Assert.*;

public class JacksonTest {
    @Test
    public void testObjectToJson() throws IOException {
        JsonGenerator jsonGenerator=null;
        ObjectMapper objectMapper = new ObjectMapper();
        BatteryMessage req=new BatteryMessage();
        req.batteryCurrent=21;
        req.cpu=24;
        req.memory=23;
        req.networkTraffic=22;
        StringWriter writer=new StringWriter();
        objectMapper.writeValue(writer, req);
        assertNotNull(writer.toString());
    }
    @Test
    public void testJsonToObject() throws IOException {
        String json="{\"UDID\":\"7211b9754480c6ad07744002a1f832f78d57933e\",\"batteryCurrent\":21.0,\"cpu\":24.0,\"memory\":23.0,\"networkTraffic\":22.0,\"createTime\": \"2015-08-13 14:07:00\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        BatteryMessage message = objectMapper.readValue(json, BatteryMessage.class);
        assertEquals(message.UDID, "7211b9754480c6ad07744002a1f832f78d57933e");
    }
}
