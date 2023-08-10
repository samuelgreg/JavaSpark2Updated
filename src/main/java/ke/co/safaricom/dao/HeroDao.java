package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.model.Hero;
import ke.co.safaricom.model.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class HeroDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();
//    Create Strength
//    List available strengths
//    Update strength (name and score)
//    Update strength details
//    Delete strength

    public static void create(Hero hero){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO heroes (name, age,squad_id) VALUES (:name, :age, :squad_id);";
            connection.createQuery(query)
                    .addParameter("name", hero.getName())
                    .addParameter("age", hero.getAge())
                    .addParameter("squad_id", hero.getSquadId())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static int findHeroById(int id){

        try(Connection connection =  sql2o.open()){
            String query = "SELECT * FROM heroes WHERE not deleted AND id = heroId;";
            connection.createQuery(query)
                    .addParameter("heroId",id)
                    .executeAndFetch( Squad.class );
            //List<Hero> Hero =  HeroDao.findHeroById( squadId );
            System.out.println(id);
            return 0;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }


}