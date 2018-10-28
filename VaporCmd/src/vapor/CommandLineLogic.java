package vapor;

import vapor.VaporAddOns.VaporPrintLibs;
import vapor.tools.Sdout;
import vapor.tools.SteamUtility;
import vaporSDK.VaporAddOn;

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
                    VaporAddOn vaporRead = new VaporPrintLibs();
                    vaporRead.setVaporCoreData(tAppdata);
                    vaporRead.runAddOn();
                    break;
                case "2":
                    doMenu = false;
                    break;
            }

        }
        tScanner.close();
    }

}
