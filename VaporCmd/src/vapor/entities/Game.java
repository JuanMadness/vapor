package vapor.entities;

@Deprecated
public class Game {

    String infoFilePath;
    String appID;
    int universe;
    String name;
    Long lastUpdated;
    Long sizeOnDisk;
    Long bytesToDownload;
    Long bytesDownloaded;

    public Game(String infoFilePath, String appID, int universe, String name, Long lastUpdated, Long sizeOnDisk, Long bytesToDownload, Long bytesDownloaded) {
        this.infoFilePath = infoFilePath;
        this.appID = appID;
        this.universe = universe;
        this.name = name;
        this.lastUpdated = lastUpdated;
        this.sizeOnDisk = sizeOnDisk;
        this.bytesToDownload = bytesToDownload;
        this.bytesDownloaded = bytesDownloaded;
    }

    public String getInfoFilePath() {
        return infoFilePath;
    }

    public String getAppID() {
        return appID;
    }

    public int getUniverse() {
        return universe;
    }

    public String getName() {
        return name;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    public Long getBytesToDownload() {
        return bytesToDownload;
    }

    public Long getBytesDownloaded() {
        return bytesDownloaded;
    }
}
