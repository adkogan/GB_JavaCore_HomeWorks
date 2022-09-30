import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Minimum")
    public TemperatureValue minimum;
    @JsonProperty("Maximum")
    public TemperatureValue maximum;


}
