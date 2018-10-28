package vaporSDK;

public interface VaporAddOn {

    public final String vaporSDKVersion = "0.2";

    public void setVaporCoreData(VaporCoreData pVaporCoreData);

    public String getAddOnName();

    public String getAddOnVersion();

    public String[] getAddOnOSSupport();

    public int runAddOn();


}
