package src.DatabaseConnection;

import java.sql.*;

public class OracleDatabase {

    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "gameAdmin";
    static final String PASS = "gameAdminpassword3";

    static Connection conn = null;

    static PreparedStatement preparedStatement;
    public OracleDatabase(){

        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement");
            stmt = conn.prepareStatement("desc user_info");

        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void createUser(String userName, String email) throws SQLException {
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,email);
    }
    public static boolean insertUser(String userName, String email) throws SQLException{

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Inserting user");
            prepareStatementforRetrieval();
            if(retrieveUserInfo(email)==true){
                return false;
            }
            prepareStatementforInsert();
            createUser(userName,email);

            preparedStatement.executeUpdate();
            System.out.println("User inserted");
            preparedStatement.close();
            conn.close();
            PlayerInfo.email = email;
            PlayerInfo.username = userName;
            PlayerInfo.gameProgress = 0;
            System.out.println("finished execution");
        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }

        return true;
    }


    public static void prepareStatementforInsert() throws SQLException {
         preparedStatement = conn.prepareStatement("insert into user_info values(?,?,0,'0')");
    }

    public static void prepareStatementforRetrieval() throws SQLException{
        preparedStatement = conn.prepareStatement("select * from user_info where email = ?");
    }


    public static void prepareStatementforCheckingLevelPlayed() throws SQLException {
        preparedStatement = conn.prepareStatement("select * from level_info where email = ? and level_number = ?");
    }

    public static boolean retrieveUserInfo(String email) throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Getting user");
            prepareStatementforRetrieval();
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                System.out.println(rs.toString());
                PlayerInfo.email = rs.getString("email");
                PlayerInfo.username = rs.getString("username");
                System.out.println();
                System.out.println("Player Info's game progress in Oracle beforeupdate is : " + PlayerInfo.gameProgress);
                PlayerInfo.gameProgress = rs.getInt("levels_completed");
                System.out.println("Player Info's game progress in Oracle Afterupdate is : " + PlayerInfo.gameProgress);
                if(rs.getString("HAS_STARTED_GAME")=="0"){
                    PlayerInfo.hasStartedGame = true;
                }
                rs.close();
                prepareStatementforCheckingLevelPlayed();
                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2,"2");
                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    PlayerInfo.DormHighScore = rs.getInt("score");
                    PlayerInfo.DormLeastTime = rs.getInt("time_taken");
                }

                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2,"3");
                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    PlayerInfo.ClassroomHighScore = rs.getInt("score");
                    PlayerInfo.ClassroomLeastTime = rs.getInt("time_taken");
                }

                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2,"4");
                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    PlayerInfo.LibraryHighScore = rs.getInt("score");
                    PlayerInfo.LibraryLeastTime = rs.getInt("time_taken");
                }

                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2,"5");
                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    PlayerInfo.CDSHighScore = rs.getInt("score");
                    PlayerInfo.CDSLeastTime = rs.getInt("time_taken");
                }

                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2,"6");
                rs = preparedStatement.executeQuery();
                if(rs.next()){
                    PlayerInfo.DormV2HighScore = rs.getInt("score");
                    PlayerInfo.DormV2LeastTime = rs.getInt("time_taken");
                }




                preparedStatement.close();
                conn.close();
                System.out.println("Got user");
            }else{
                return false;
            }
        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }

        return true;
    }

    private static void prepareStatementForScoreUpdate() throws SQLException {
        preparedStatement = conn.prepareStatement("update level_info set score = ? where email = ? and level_number = ?");
    }

    private static void prepareStatementForTimeUpdate() throws SQLException {
        preparedStatement = conn.prepareStatement("update level_info set time_taken = ? where email = ? and level_number = ?");
    }
    private static void prepareStatementForLevelInsert() throws SQLException{
        preparedStatement = conn.prepareStatement("insert into level_info values(?,?,?,?)");

    }

    private static void prepareStatementforUserInfoLevelsCompletedUpdate() throws SQLException{
        preparedStatement = conn.prepareStatement("update user_info set levels_completed = ? where email = ?");
    }

    public static void updatePlayerStats(Integer level, Integer score, Integer time){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            prepareStatementforUserInfoLevelsCompletedUpdate();
            preparedStatement.setString(1, String.valueOf(PlayerInfo.gameProgress));
            preparedStatement.setString(2, PlayerInfo.email);
            preparedStatement.executeUpdate();
            System.out.println("herhe");
            prepareStatementforCheckingLevelPlayed();
            preparedStatement.setString(1, PlayerInfo.email);
            preparedStatement.setString(2,level.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){

                prepareStatementForScoreUpdate();
                preparedStatement.setString(1, score.toString());
                preparedStatement.setString(2, PlayerInfo.email);
                preparedStatement.setString(3,level.toString());
                preparedStatement.executeUpdate();

                prepareStatementForTimeUpdate();
                preparedStatement.setString(1, time.toString());
                preparedStatement.setString(2, PlayerInfo.email);
                preparedStatement.setString(3,level.toString());
                preparedStatement.executeUpdate();

            }else{
                prepareStatementForLevelInsert();
                preparedStatement.setString(1, PlayerInfo.email);
                preparedStatement.setString(2, level.toString());
                preparedStatement.setString(3, score.toString());
                preparedStatement.setString(4, time.toString());
                preparedStatement.execute();
            }

            preparedStatement.close();
            conn.close();
        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public static boolean resetPlayerInfo(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            prepareStatementforUserInfoLevelsCompletedUpdate();
            preparedStatement.setString(1, String.valueOf(PlayerInfo.gameProgress));
            preparedStatement.setString(2, PlayerInfo.email);
            preparedStatement.executeUpdate();
            System.out.println("herhe");
            prepareStatementForReset();
            preparedStatement.setString(1, PlayerInfo.email);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            return true;
        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();

        }

        return false;

    }
    private static void prepareStatementForReset() throws SQLException {
        preparedStatement = conn.prepareStatement("delete from level_info where email=?");
    }


}