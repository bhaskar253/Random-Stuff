package scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class YuzuGamesScrapper implements Scrapper<Game> {

    String url;

    static Logger logger = Logger.getLogger(YuzuGamesScrapper.class.getSimpleName());

    public YuzuGamesScrapper(String url) {
        this.url = url;
    }

    public List<Game> scrape() {
        List<Game> result = null;
        try {
            Document doc = Jsoup.connect(url)
                    .sslSocketFactory(Utils.socketFactory())
                    .get();
            Elements games = doc.select("tr");
            result = new ArrayList<>();
            for (int i = 8; i < games.size(); i++) {
                Element game = games.get(i);
                result.add(new Game(
                    game.child(0).child(0).ownText(),
                    game.child(1).child(1).ownText(),
                    game.child(2).child(0).ownText()
                ));
            }
        } catch (IOException exception) {
            throw new RuntimeException("Failed to parse the game entries", exception);
        }
        return result;

    }
}
