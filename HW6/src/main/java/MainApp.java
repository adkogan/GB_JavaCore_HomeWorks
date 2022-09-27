import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.util.Properties;


public class MainApp {

    public static void main(String[] args) throws IOException {

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
        System.out.println(jsonResponse);

    }
}
