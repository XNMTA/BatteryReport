package main.java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class BatteryRegiestResponse {

    private String content;

    public BatteryRegiestResponse() {
        // Jackson deserialization
    }

    public BatteryRegiestResponse(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
