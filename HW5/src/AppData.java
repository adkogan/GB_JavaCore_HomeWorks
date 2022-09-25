import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class AppData {

        private String[] header;
        private int[][] data;

        public void setHeader(String[] header) {
            this.header = header;
        }

        public void setData(int[][] data) {
            this.data = data;
        }

        public String title() {
            return String.join(";", header);
        }

        public List<String> dataAsStrings() {
            return Arrays
                .stream(data)
                .map(a -> Arrays
                        .stream(a)
                        .mapToObj(e -> String.valueOf(e))
                        .collect(Collectors.joining(";"))
                )
                .collect(Collectors.toList());
        }
}
