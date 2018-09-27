package vapor.tools;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;

import java.util.List;

public class SteamUtility {

    public static List<SteamLibrary> getSteamLibraries() {
        //erstellt pro SteamLibPath ein SteamLibrary Objekt und füllt es mit Game Objekten
        return null;
    }

    private static List<String> getSteamLibPaths() {
        //soll im Steam installationsverzeichnis aus einer config die pfade lesen
        return null;
    }

    private static List<Game> getGamesFromLib(String pPath) {
        //holt sich spiele infos aus der SteamLiberay
        return null;
    }
}
