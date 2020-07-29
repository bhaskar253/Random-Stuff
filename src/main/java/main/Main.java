package main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import scrapper.Game;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

//        List<Game> games = new Scrapper("https://yuzu-emu.org/game/").scrape();
//        try(Writer writer = Files.newBufferedWriter(Paths.get("games.json"))) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            gson.toJson(games, writer);
//        }

        games = null;
        String gamesJsonPath = "src/main/resources/games.json";
        try (Reader reader = Files.newBufferedReader(Paths.get(gamesJsonPath))) {
            games = new Gson().fromJson(reader, new TypeToken<List<Game>>(){}.getType());
        }
        Logger myLogger = Logger.getAnonymousLogger();
        String size = String.valueOf(gameTestedInYear("2020").size());
        myLogger.info(size);
    }

    private static List<Game> games;

    private static List<Game> gameTestedInYear(String year) throws Exception {
        if(!isValidYear(year)) {
            throw new Exception("Input year should be in range 2018-" + LocalDate.now().getYear());
        }
        return games.stream()
                .filter(game -> game.getDateTested().endsWith(year))
                .collect(Collectors.toList());
    }

    private static boolean isValidYear(String year) {
        String regex = "^2...$";
        if (!year.matches(regex))
            return false;
        Integer y = Integer.parseInt(year);
        return y <= LocalDate.now().getYear() && y >= 2018;
    }
}