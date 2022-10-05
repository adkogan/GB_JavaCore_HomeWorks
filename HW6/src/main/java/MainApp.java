import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class MainApp {

    public static void main(String[] args) throws IOException, SQLException {


        String token = "";
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            token = prop.getProperty("token");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }


        HttpUrl url = new HttpUrl
                .Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", token)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());


        Request requestHttp = new Request
                .Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = new OkHttpClient()
                .newCall(requestHttp)
                .execute()
                .body()
                .string();

        //System.out.println(jsonResponse);
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        WeatherResponse weatherResponse = objectMapper.readValue(jsonResponse, WeatherResponse.class);


        WeatherRepository weatherRepository = new WeatherRepository();





        for (DailyForecast forecast : weatherResponse.forecasts) {
            System.out.println(
                    String.format(
                            "В городе %s на дату %s ожидается днем: %s, ночью: %s температура:  %s - %s",
                            "Санкт-Петербурге",
                            forecast.date.format(DateTimeFormatter.ofPattern("EEE, MMM d, yy")),
                            forecast.day.printable(),
                            forecast.night.printable(),
                            forecast.temperature.minimum.printable(),
                            forecast.temperature.maximum.printable()
                    )
            );
            weatherRepository
                .saveWeatherData(
                    new WeatherRecord(
                        "Санкт-Петербург",
                            forecast.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            forecast.day.printable(),
                            forecast.temperature.maximum.value
                    )
                );
        }
    }



    private static void performDropTable(Statement statement) {
    }

}



