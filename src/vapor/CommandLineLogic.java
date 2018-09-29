package vapor;

import vapor.tools.Sdout;
import vapor.tools.SteamUtility;
import vapor.tools.SystemInfo;

public class CommandLineLogic {

    SystemInfo systemInfo;

    public CommandLineLogic() {
        //init
        systemInfo = new SystemInfo();
        Sdout.isDebugEnabled = true;

        //weitere logik

        SteamUtility.getSteamLibraries();
    }

}
