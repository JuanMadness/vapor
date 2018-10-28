package vaporSDK;

import vaporSDK.entities.SteamLibrary;

import java.util.List;

public interface VaporCoreData {

    public String getOs();

    public List<SteamLibrary> getLocalSteamLibraries();

    public void setLocalSteamLibraries(List<SteamLibrary> localSteamLibraries);
}
