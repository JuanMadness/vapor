package vapor;

import vaporSDK.VaporCoreData;

import java.util.HashMap;

public class AppData implements VaporCoreData {

    private static AppData appData = new AppData();
    private static HashMap<String, Object> vaporCoreData = new HashMap<>();

    private String os;

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


    @Override
    public HashMap<String, Object> getVaporCoreData() {
        return vaporCoreData;
    }
}
