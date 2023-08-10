package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.dto.Option;
import ke.co.safaricom.dto.SquadInformation;
import ke.co.safaricom.model.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class SquadDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();
    public static void create(Squad squad){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO squads (name, cause,max_size) VALUES (:name, :cause, :max_size);";
            connection.createQuery(query)
                    .addParameter("name", squad.getName())
                    .addParameter("cause", squad.getCause())
                    .addParameter("max_size", squad.getMax_size())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static SquadInformation findSquadById(int id){

        try(Connection connection =  sql2o.open()){
            String query = "SELECT * FROM squads WHERE not deleted AND id = squadId;";
            connection.createQuery(query)
                    .addParameter("id",id)
                    .executeAndFetch( Squad.class );
            SquadInformation information = new SquadInformation();
            //information.setSquad( squads );
            //information.setHeroes( heroes );
            //information.setWeaknessScore( 0 );
            // information.setStrengthScore( 0 );
            // information.setWeaknessScore(create(heroes,0) );
            // information.setStrengthScore( create(heroes,0);
            System.out.println(id);
            return null;
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }

    }
    public static List<Option> getSquadOption() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT id,name as text from squads";
            List<Option> listOption = connection.createQuery( query )
                    .executeAndFetch( Option.class );
            System.out.println( listOption );
            return listOption;
        } catch (Exception exception) {
            System.out.println( exception.getMessage() );
            return null;
        }


    }


}