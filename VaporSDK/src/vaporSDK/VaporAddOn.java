package vaporSDK;

public interface VaporAddOn {

    public static final String vaporSDKVersion = "0.2";

    public void setVaporCoreData(VaporCoreData vaporCoreData);

    public String getVaporSDKVersion();

    public String getAddOnName();

    public String getAddOnVersion();

    public String[] getAddOnOSSupport();

    public int runAddOn();


}
