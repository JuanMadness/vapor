package vaporSDK;

public interface VaporAddOn {

    public static final String vaporSDKVersion = "0.3";

    public String getVaporSDKVersion();

    public String getAddOnName();

    public String getAddOnVersion();

    public String[] getAddOnOSSupport();

    public int runAddOn(VaporCoreData vaporCoreData);


}
