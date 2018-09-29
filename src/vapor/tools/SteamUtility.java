package vapor.tools;

import vapor.entities.Game;
import vapor.entities.SteamLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SteamUtility {

    public static String USER_SET_STEAMPATH = null;
    private static String DEFAULT_STEAMPATH_WINDOWS = "C:\\Program Files (x86)\\Steam";
    private static String DEFAULT_STEAMPATH_LINUX = "";


    public static List<SteamLibrary> getSteamLibraries() {
        List<String> tSteamLibPaths = getSteamLibPaths();
        if (tSteamLibPaths == null) {
            Sdout.info("No steamLibs found!");
            return null;
        }

        List<SteamLibrary> tSteamLibs = new ArrayList<SteamLibrary>();
        for (String tLibPath : tSteamLibPaths) {
            tSteamLibs.add(new SteamLibrary(tLibPath, getGamesFromLib(tLibPath)));
        }

        return tSteamLibs;
    }

    private static List<String> getSteamLibPaths() {
        Sdout.info("Reading paths of steamLibs...");
        try {
            BufferedReader tBufferedReader = new BufferedReader(new FileReader(DEFAULT_STEAMPATH_WINDOWS + "\\steamapps\\libraryfolders.vdf"));

            Pattern tPatternLibLine = Pattern.compile("\\W\\d\\W\\s+\\W.+\\W");

            List<String> tSteamLibPaths = new ArrayList<String>();
            tSteamLibPaths.add(DEFAULT_STEAMPATH_WINDOWS);
            String tLine;
            while ((tLine = tBufferedReader.readLine()) != null) {
                Matcher tMatcher = tPatternLibLine.matcher(tLine);

                if (tMatcher.find()) {
                    //Sdout.debug(tLine);
                    Pattern tPatternLibPath = Pattern.compile("\\s\\\"(\\D+)\\\"");
                    tMatcher = tPatternLibPath.matcher(tLine);

                    if (tMatcher.find()) {
                        Sdout.debug(tMatcher.group(1));
                        tSteamLibPaths.add(tMatcher.group(1));
                    }
                }
            }
            tBufferedReader.close();
            Sdout.info(String.valueOf(tSteamLibPaths.size()) + " steamLibs found");
            return tSteamLibPaths;
        } catch (FileNotFoundException e) {
            Sdout.error("FileNotFoundException: getSteamLibPaths");
        } catch (IOException e) {
            Sdout.error("IOException: getSteamLibPaths");
        }
        return null;
    }

    private static List<Game> getGamesFromLib(String pPath) {
        Sdout.info("Reading games from " + pPath);
        pPath = pPath + "\\steamapps";

        List<Game> tGames = new ArrayList<Game>();

        File tSteamapps = new File(pPath);
        Pattern tAppmanifest = Pattern.compile("appmanifest_\\d+\\.acf");
        for (File tFile : tSteamapps.listFiles()) {
            Matcher tMatcher = tAppmanifest.matcher(tFile.getName());
            if (!tFile.isDirectory() && tMatcher.find()) {
                Sdout.debug("Found " + tFile.getName());

                try {
                    String tAppid = null, tUniverse = null, tName = null, tLastUpdated = null, tSizeOnDisk = null, tBytesToDownload = null, tBytesDownloaded = null;
                    BufferedReader tBufferedReader = new BufferedReader(new FileReader(tFile));
                    Pattern tPropertyName = Pattern.compile("\"([a-zA-Z]+)\"");

                    String tLine;
                    while ((tLine = tBufferedReader.readLine()) != null) {
                        tMatcher = tPropertyName.matcher(tLine);
                        if (tMatcher.find()) {
                            if (tMatcher.group(1).equals("language")) {
                                break;
                            }
                            Pattern tPropertyValue = Pattern.compile("\"[a-zA-Z]+\"\\s+\"(.*)\"");
                            Matcher tValueMatcher = tPropertyValue.matcher(tLine);
                            switch (tMatcher.group(1)) {
                                case "appid":
                                    tValueMatcher.find();
                                    tAppid = tValueMatcher.group(1);
                                    break;
                                case "Universe":
                                    tValueMatcher.find();
                                    tUniverse = tValueMatcher.group(1);
                                    break;
                                case "name":
                                    tValueMatcher.find();
                                    tName = tValueMatcher.group(1);
                                    break;
                                case "LastUpdated":
                                    tValueMatcher.find();
                                    tLastUpdated = tValueMatcher.group(1);
                                    break;
                                case "SizeOnDisk":
                                    tValueMatcher.find();
                                    tSizeOnDisk = tValueMatcher.group(1);
                                    break;
                                case "BytesToDownload":
                                    tValueMatcher.find();
                                    tBytesToDownload = tValueMatcher.group(1);
                                    break;
                                case "BytesDownloaded":
                                    tValueMatcher.find();
                                    tBytesDownloaded = tValueMatcher.group(1);
                                    break;
                            }
                        }
                    }
                    Sdout.debug("Found " + tName + "(" + tAppid + ")");
                    tGames.add(new Game(tFile.getPath(),tAppid,Integer.parseInt(tUniverse), tName, Long.parseLong(tLastUpdated), Long.parseLong(tSizeOnDisk),
                            Long.parseLong(tBytesToDownload), Long.parseLong(tBytesDownloaded)));
                    tBufferedReader.close();
                } catch (FileNotFoundException e) {
                    Sdout.error("FileNotFoundException: getGamesFromLib");
                } catch (IOException e) {
                    Sdout.error("IOException: getGamesFromLib");
                }

            }
        }
        return tGames;
    }
}
