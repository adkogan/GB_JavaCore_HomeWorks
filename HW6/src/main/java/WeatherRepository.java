import java.io.IOException;
import java.sql.*;
import java.util.List;

class WeatherRepository {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public WeatherRepository() throws SQLException {
        createTableIfNotExists();

    }

    String filename = "hw8.db";
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "city TEXT NOT NULL," +
            "date_time TEXT NOT NULL," +
            "weather_text TEXT NOT NULL," +
            "temperature REAL NOT NULL" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";



    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() throws SQLException {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        }
    }


    public boolean saveWeatherData(WeatherRecord weatherRecord) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)
        ) {
            saveWeather.setString(1, weatherRecord.city);
            saveWeather.setString(2, weatherRecord.localDate);
            saveWeather.setString(3, weatherRecord.text);
            saveWeather.setDouble(4, weatherRecord.temperature);
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }


    public List<WeatherRecord> getAllSavedData() throws IOException {
        throw new IOException("Not implemented exception");
    }

}