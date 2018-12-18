package vapor;

import vapor.tools.Sdout;
import vapor.tools.SteamUtility;
import vaporSDK.VaporAddOn;

import java.util.HashMap;
import java.util.Scanner;

public class CommandLineLogic {

    private AppData tAppdata;

    public CommandLineLogic() {
        //init
        tAppdata = AppData.getInstance();
        Sdout.isDebugEnabled = false;

        //scanning local libs
        tAppdata.getVaporCoreData().put(VaporCoreDataKeys.LOCAL_STEAM_LIBS, SteamUtility.getSteamLibraries());

        boolean doMenu = true;
        Scanner tScanner = new Scanner(System.in);

        HashMap<String, VaporAddOn> tMenuHashMap = new HashMap<>();

        //menu loop
        while (doMenu) {
            tMenuHashMap.clear();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

            int i = 1;
            for (VaporAddOn tVaporAddOn : tAppdata.getVaporAddOns()) {
                tMenuHashMap.put(String.valueOf(i), tVaporAddOn);
                System.out.println(i + " " + tVaporAddOn.getAddOnName());
                i++;
            }
            System.out.println("0 Exit");

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String input = tScanner.next();
            if (input.equals("0")) break;
            if (!tMenuHashMap.containsKey(input)) {
                System.out.println("No Tasks found for " + i);
                continue;
            }

            VaporAddOn tSelectedAddOn = tMenuHashMap.get(input);
            tSelectedAddOn.runAddOn(tAppdata);
        }
        tScanner.close();
    }

}
