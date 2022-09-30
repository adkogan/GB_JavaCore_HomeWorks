import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    @JsonProperty("Date")
    public OffsetDateTime date;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("Day")
    public WeatherDescription day;
    @JsonProperty("Night")
    public WeatherDescription night;


}
