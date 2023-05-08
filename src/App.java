import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address = URI.create(url);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> MoviesList = parser.parse(body);

        var generator = new StickerGenerator();
        for (Map<String, String> film : MoviesList) {

            String imageUrl = film.get("image");
            String title = film.get("title");

            InputStream inputStream = new URL(imageUrl).openStream();

            String fileName = "saida/" + title + ".png";
            generator.create(inputStream, fileName);

        }
    }
}
