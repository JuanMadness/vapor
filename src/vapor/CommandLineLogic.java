package vapor;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;
import vapor.tools.Sdout;
import vapor.tools.SteamUtility;

import java.util.Scanner;

public class CommandLineLogic {

    private AppData tAppdata;

    public CommandLineLogic() {
        //init
        tAppdata = AppData.getInstance();
        Sdout.isDebugEnabled = false;

        //scanning local libs
        tAppdata.setLocalSteamLibraries(SteamUtility.getSteamLibraries());

        boolean doMenu = true;
        Scanner tScanner = new Scanner(System.in);

        //menu loop
        while (doMenu) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1.PrintAllGames");
            System.out.println("2.Exit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String input = tScanner.next();
            switch (input) {
                case "1":
                    printAllLibs();
                    break;
                case "2":
                    doMenu = false;
                    break;
            }

        }
        tScanner.close();
    }

    private void printAllLibs() {
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
