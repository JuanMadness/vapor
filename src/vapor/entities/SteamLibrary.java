package vapor.entities;

import java.util.List;

public class SteamLibrary {

    String path;
    List<Game> games;

    public SteamLibrary(String pPath, List<Game> pGames) {
        path = pPath;
        games = pGames;
    }

    public String getPath() {
        return path;
    }

    public List<Game> getGames() {
        return games;
    }


}
