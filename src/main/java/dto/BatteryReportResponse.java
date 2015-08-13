package main.java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class BatteryReportResponse {
    private long id;

    @Length(max = 3)
    private String content;

    public BatteryReportResponse() {
        // Jackson deserialization
    }

    public BatteryReportResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
