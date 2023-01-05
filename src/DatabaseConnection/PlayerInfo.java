package src.DatabaseConnection;

public class PlayerInfo {
    public static String username;
    public static String email;
    public static int gameProgress = 0;

    public static boolean hasStartedGame = false;
    public static int DormHighScore = -1;
    public static int DormLeastTime = -1;

    public static int ClassroomHighScore = -1;
    public static int ClassroomLeastTime = -1;

    public static int LibraryHighScore = -1;
    public static int LibraryLeastTime = -1;

    public static int CDSHighScore = -1;
    public static int CDSLeastTime = -1;

    public static int DormV2HighScore = -1;
    public static int DormV2LeastTime = -1;

    public static int numberOfFinished = 0;

    public PlayerInfo(int gameProgress){
        PlayerInfo.gameProgress = gameProgress;
    }


    public static String getString(){
        return username+" "+email+" "+gameProgress+"\n";
    }

}

