package vapor;

import vapor.VaporAddOns.VaporPrintLibs;
import vaporSDK.VaporAddOn;
import vaporSDK.VaporCoreData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppData implements VaporCoreData {

    private static AppData appData = new AppData();
    private static HashMap<String, Object> vaporCoreData = new HashMap<>();
    private static List<VaporAddOn> vaporAddOns = new ArrayList<>();

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



    public List<VaporAddOn> getVaporAddOns() {
        /**
         * Add new VaporAddOns here
         */
        vaporAddOns.add(new VaporPrintLibs());
        return vaporAddOns;
    }


    @Override
    public HashMap<String, Object> getVaporCoreData() {
        return vaporCoreData;
    }
}
