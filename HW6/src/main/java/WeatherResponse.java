import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("DailyForecasts")
    public List<DailyForecast> forecasts;



}
