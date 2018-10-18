package vapor;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;
import vapor.tools.Sdout;
import vapor.tools.SteamUtility;

public class CommandLineLogic {

    private AppData tAppdata;

    public CommandLineLogic() {
        //init
        tAppdata = AppData.getInstance();
        Sdout.isDebugEnabled = false;

        //scanning local libs
        tAppdata.setLocalSteamLibraries(SteamUtility.getSteamLibraries());
        //weitere logik
        //SteamCmdUtility.textSteamCmd();
        //SteamCmdUtility.updateAllGames(SteamUtility.getSteamLibraries());

        printAllLibs();
    }

    public void printAllLibs() {
        for (SteamLibrary tLib : tAppdata.getLocalSteamLibraries()) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(tLib.getPath());
            for (Game tGame : tLib.getGames()) {
                System.out.printf("%-50s %-10s%n", tGame.getName(), tGame.getAppID());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

}
