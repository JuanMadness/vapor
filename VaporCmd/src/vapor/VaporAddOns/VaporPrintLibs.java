package vapor.VaporAddOns;

import vapor.VaporCoreDataKeys;
import vaporSDK.VaporAddOn;
import vaporSDK.VaporCoreData;
import vaporSDK.entities.Game;
import vaporSDK.entities.SteamLibrary;

import java.util.List;

public class VaporPrintLibs implements VaporAddOn {

    @Override
    public String getVaporSDKVersion() {
        return VaporAddOn.vaporSDKVersion;
    }

    @Override
    public String getAddOnName() {
        return "VaporPrintLibs";
    }

    @Override
    public String getAddOnVersion() {
        return "1.0.1";
    }

    @Override
    public String[] getAddOnOSSupport() {
        String[] tSupportedOs = new String[1];
        tSupportedOs[0] = "windows";
        tSupportedOs[1] = "linux";
        return tSupportedOs;
    }

    @Override
    public int runAddOn(VaporCoreData vaporCoreData) {
        if (!vaporCoreData.getVaporCoreData().containsKey(VaporCoreDataKeys.LOCAL_STEAM_LIBS)) return 1;

        for (SteamLibrary tLib : (List<SteamLibrary>) vaporCoreData.getVaporCoreData().get(VaporCoreDataKeys.LOCAL_STEAM_LIBS)) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(tLib.getPath());
            for (Game tGame : tLib.getGames()) {
                System.out.printf("%-50s %-10s%n", tGame.getName(), tGame.getAppID());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        return 0;
    }
}
