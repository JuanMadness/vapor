package vapor;

import vaporSDK.VaporCoreData;
import vaporSDK.entities.SteamLibrary;

import java.util.List;

public class AppData implements VaporCoreData {

    private static AppData appData = new AppData();

    private String os;
    private List<SteamLibrary> localSteamLibraries;

    public static String OS_WINDOWS = "windows";
    public static String OS_LINUX = "linux";



    private AppData() {
        //setting os
        String tOS = System.getProperty("os.name");
        if (tOS.contains("windows")) {
            os = OS_WINDOWS;
        } else if (tOS.contains("linux")) {
            os = OS_LINUX;
        }
    }

    public static AppData getInstance() {
        return appData;
    }

    public String getOs() {
        return os;
    }

    public List<SteamLibrary> getLocalSteamLibraries() {
        return localSteamLibraries;
    }

    public void setLocalSteamLibraries(List<SteamLibrary> localSteamLibraries) {
        this.localSteamLibraries = localSteamLibraries;
    }
}
