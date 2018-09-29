package vapor;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;
import vapor.tools.Sdout;
import vapor.tools.SteamUtility;
import vapor.tools.SystemInfo;

import java.util.List;

public class CommandLineLogic {

    SystemInfo systemInfo;

    public CommandLineLogic() {
        //init
        systemInfo = new SystemInfo();
        Sdout.isDebugEnabled = false;

        //weitere logik
        //SteamCmdUtility.textSteamCmd();
        //SteamCmdUtility.updateAllGames(SteamUtility.getSteamLibraries());

        printAllLibs();
    }

    public void printAllLibs() {
        List<SteamLibrary> tSteamLibs = SteamUtility.getSteamLibraries();

        for (SteamLibrary tLib : tSteamLibs) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(tLib.getPath());
            for (Game tGame : tLib.getGames()) {
                System.out.printf("%-50s %-10s%n", tGame.getName(), tGame.getAppID());
            }
        }
    }

}
