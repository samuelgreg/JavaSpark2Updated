package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.model.Weakness;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class WeaknessDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();


    //    Create Weakness
//    List available Weakness
//    Update strength (name and score)
//    Update Weakness details
//    Delete weakness
    public static void create(Weakness weakness){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO weakness (name, score) VALUES (:name, :score);";
            connection.createQuery(query)
                    .addParameter("name", weakness.getName())
                    .addParameter("score", weakness.getScore())
                    .executeUpdate();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
    public static int getScoreById(int id){

        try(Connection connection =  sql2o.open()){
            String query = "SELECT score FROM weakness WHERE id = :id;";
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
