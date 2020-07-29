package scrapper;

public class Game {

    private String gameTitle;
    private String compatibility;
    private String dateTested;

    public Game() {
    }

    public Game(String gameTitle, String compatibility, String dateTested) {
        this.gameTitle = gameTitle;
        this.compatibility = compatibility;
        this.dateTested = dateTested;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public String getDateTested() {
        return dateTested;
    }

    public void setDateTested(String dateTested) {
        this.dateTested = dateTested;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameTitle='" + gameTitle + '\'' +
                ", compatibility='" + compatibility + '\'' +
                ", dateTested='" + dateTested + '\'' +
                '}';
    }
}
