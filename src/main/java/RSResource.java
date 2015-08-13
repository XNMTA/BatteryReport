package main.java;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import main.java.dto.BatteryMessage;
import main.java.dto.BatteryRegiestResponse;
import org.apache.commons.io.FileUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;

@Path("/battery")
@Produces(MediaType.APPLICATION_JSON)
public class RSResource {
    private final String template;

    public RSResource(String template) {
        this.template = template;
    }

    @GET
    @Timed
    public BatteryRegiestResponse sayHello(@QueryParam("data") Optional<String> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            BatteryMessage message = objectMapper.readValue(data.get(), BatteryMessage.class);
            SaveData(message);
        } catch (IOException e) {
            return new BatteryRegiestResponse("failed");

        }
        return new BatteryRegiestResponse("succeed");
    }

    private void SaveData(BatteryMessage message) throws IOException {
        String save = String.format("%s,%s,%s,%s,%s\n",
                message.batteryCurrent, message.cpu, message.memory, message.networkTraffic, message.createTime);
        File file = new File(message.UDID);

        FileUtils.writeStringToFile(file, save,true);
    }

}