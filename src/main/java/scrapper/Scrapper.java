package scrapper;

import java.util.List;

public interface Scrapper<T> {
    List<T> scrape();
}
