import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class MainApp {


    public static final String DATA_INPUT_FILE_CSV = "inputFile.csv";

    public static void main(String[] args) throws IOException {

        // Создаем данные
        AppData appData = new AppData();
        appData.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});

        appData.setData(new int[][]{
                {100, 200, 123},
               {300, 400, 500}
        });


        // Создаем файл
        File file = new File(DATA_INPUT_FILE_CSV);
        if (!file.exists()) {
            file.createNewFile();
        }


        // Записываем в файл
        FileWriter myWriter = new FileWriter(DATA_INPUT_FILE_CSV);
        myWriter.write(appData.title() + System.getProperty("line.separator"));

        for (String rowAsString : appData.dataAsStrings()) {
            myWriter.write(rowAsString + System.getProperty("line.separator"));

        }
        myWriter.close();

        //Читаем из файла
        Path filePath = Path.of(DATA_INPUT_FILE_CSV);

        String content = Files.readString(filePath);
        System.out.println(content);




    }
}
