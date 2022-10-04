import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureValue {
    @JsonProperty("Value")
    public float value;
    @JsonProperty("Unit")
    public String unit;



    public String printable() {
        return value + unit;
    }
}

