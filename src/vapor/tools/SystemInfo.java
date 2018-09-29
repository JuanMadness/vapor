package vapor.tools;

public class SystemInfo {

    //soll im Konsturktor alle nötigen infos holen
    //zB Betriebsystem

    String systemOS;

    //os
    public static String OS_WINDOWS = "windows";
    public static String OS_LINUX = "linux";

    public SystemInfo() {
        setSystemOS();
    }

    public String getSystemOS() {
        return systemOS;
    }

    private void setSystemOS() {
        String tOS = System.getProperty("os.name");
        if (tOS.contains("windows")) {
            systemOS = OS_WINDOWS;
        } else if (tOS.contains("linux")) {
            systemOS = OS_LINUX;
        }
    }
}
