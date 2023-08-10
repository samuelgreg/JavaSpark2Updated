package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.model.Strength;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class StrengthDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();
//    Create Strength
//    List available strengths
//    Update strength (name and score)
//    Update strength details
//    Delete strength

    public static void create(Strength strength){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO strength (name, score) VALUES (:name, :score);";
            connection.createQuery(query)
                    .addParameter("name", strength.getName())
                    .addParameter("score", strength.getScore())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static int getScoreById(int id){

        try(Connection connection =  sql2o.open()){
            String query = "SELECT score FROM strength WHERE id = :id;";
            int score = connection.createQuery(query)
                    .addParameter("id", id)
                    .executeScalar(Integer.class);
            System.out.println(score);
            return 0;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }


}