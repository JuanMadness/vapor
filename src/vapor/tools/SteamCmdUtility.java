package vapor.tools;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SteamCmdUtility {

    //cmd="steamcmd +login $user $userPw"
    //+app_update appID
    //+quit

    public static String steamCmdPath = "C:\\Program Files (x86)\\Steam\\steamcmd.exe";

    private static void runSteamCmd(String pCmd) {
        //führt SteamCmd mit parameter aus
        StringBuilder tCmd = new StringBuilder();
        tCmd.append(" +login test +ShutdownOnFailedCommand 1 ");
        tCmd.append(pCmd);
        tCmd.append("+exit");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(steamCmdPath, tCmd.toString());
            processBuilder.inheritIO();


            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException e) {
            Sdout.error("IOException: runSteamCmd");
            e.printStackTrace();
        } catch (InterruptedException e) {
            Sdout.error("InterruptedException: runSteamCmd");
        }
    }

    public static void updateAllGames(List<SteamLibrary> pSteamLibs) {
        //erstellt Befehlt um alle Spiele in den Libs zu updaten
        List<String> tAppIds = new ArrayList<String>();

        for (SteamLibrary tSteamLib : pSteamLibs) {
            for (Game tGame : tSteamLib.getGames()) {
                tAppIds.remove(tGame.getAppID());
                tAppIds.add(tGame.getAppID());
            }
        }

        StringBuilder tCmd = new StringBuilder();
        for (String tString : tAppIds) {
            tCmd = tCmd.append("+app_update " + tString + " ");
        }

        runSteamCmd(tCmd.toString());
    }

    public static void updateGame(Game pGame) {
        //erstellt befehl um ein Spiel zu updaten/hinzuzufügen
    }

    public static void addNewGame(String pAppId, String pUniverse) {
        //downloads new game
    }

    public static void textSteamCmd() {
        runSteamCmd("+app_update 500710 ");
    }
}
