public class WeatherRecord {

    public String city;
    public String localDate;
    public String text;
    public Double temperature;

    public WeatherRecord(String city, String localDate, String text, Double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.text = text;
        this.temperature = temperature;
    }
}
