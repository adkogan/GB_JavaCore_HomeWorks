import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDescription {
    @JsonProperty("IconPhrase")
    public String iconPhrase;


    public String printable() {
        return iconPhrase;
    }
}
