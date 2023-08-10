package ke.co.safaricom;

import ke.co.safaricom.dao.HeroDao;
import ke.co.safaricom.dao.SquadDao;
import ke.co.safaricom.dao.StrengthDao;
import ke.co.safaricom.dao.WeaknessDao;
import ke.co.safaricom.model.Hero;
import ke.co.safaricom.model.Squad;
import ke.co.safaricom.model.Strength;
import ke.co.safaricom.model.Weakness;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8083);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        staticFiles.registerMimeType("html", "text/html");
        staticFiles.registerMimeType("hbs", "text/html");
        staticFiles.externalLocation("src/main/resources");
        get("/strength/add",(request, response) ->{
            return new ModelAndView( new HashMap<>(), "create-strength.hbs");
        },new HandlebarsTemplateEngine());


        post("/create-strength",(request, response) -> {
            String name = request.queryParams("strength");
            String score = request.queryParams("score");
            Strength strength =new Strength();
            strength.setScore(Integer.parseInt( score ));
            strength.setName( name );
            StrengthDao.create( strength );
            System.out.println(name + " " +score);
            String alertScript = "<script>alert('successful added strength "+name+"');</script>";
            return alertScript;
        });
        get("/weakness/add",(request, response) ->{
            return new ModelAndView( new HashMap<>(), "create-weakness.hbs");
        },new HandlebarsTemplateEngine());


        post("/create-weakness",(request, response) -> {
            String name = request.queryParams("weakness");
            String score = request.queryParams("score");
            Weakness weakness =new Weakness();
            weakness.setScore(Integer.parseInt( score ));
            weakness.setName( name );
            WeaknessDao.create(weakness );
            System.out.println(name + " " +score);
            String alertScript = "<script>alert('successful added weakness "+name+"');</script>";
            return alertScript;
        });
        get("/squad/add",(request, response) ->{
            return new ModelAndView( new HashMap<>(), "squad.hbs");
        },new HandlebarsTemplateEngine());


        post("/create-squad",(request, response) -> {
            String name = request.queryParams("squad");
            String cause = request.queryParams("cause");
            String max_size = request.queryParams("max_size");
            Squad squad =new Squad();
            squad.setMax_size(Integer.parseInt( max_size ));
            squad.setName( name );
            squad.setCause( cause );
            SquadDao.create(squad);
            System.out.println(name + " " +max_size);
            String alertScript = "<script>alert('successful added squad "+name+"');</script>";
            return alertScript;
        });
        get("/hero/add",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("options", SquadDao.getSquadOption());
            return new ModelAndView(model, "hero.hbs");
        },new HandlebarsTemplateEngine());


        post("/create-hero",(request, response) -> {
            String name = request.queryParams("hero");
            String age = request.queryParams("age");
            String squadId = request.queryParams("squadId");
            Hero hero =new Hero();
            hero.setAge(Integer.parseInt( age));
            hero.setName( name );
            hero.setSquadId( Integer.parseInt( squadId ) );
            HeroDao.create(hero );
            System.out.println(name + " " +age);
            String alertScript = "<script>alert('successful added hero "+name+"' );</script>";
            return alertScript;
        });
        //SquadDao.findSquadById( id=1 );
        //HeroDao.findHeroById( heroId=1 );
        //System.out.println(SquadDao.findSquadById(
        // ));

    }

}


