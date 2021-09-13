import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/hero-form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getInstances();
            model.put("hero", heroes);
            return  new ModelAndView(model, "hero.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/new/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(request.params(":id"));
            Hero selectedHero = Hero.findById(idOfHero);
            model.put("hero", selectedHero);
            return new ModelAndView(model, "scores.hbs");
        });

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getInstances();
            model.put("heroes",members);
            Squad newSquad = Squad.findById(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        },
                new HandlebarsTemplateEngine());

        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("name");
            Integer size = Integer.parseInt(req.queryParams("participants"));
            String cause = req.queryParams("mission");
            Squad squad = new Squad(squadName, cause);
            req.session().attribute("item",squadName);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        },
                new HandlebarsTemplateEngine());

        post("/new/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness);
            req.session().attribute("item",name);
            model.put("item",req.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/new/member/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("selectedSquad",request.params("id"));
            model.put("selectedSquad", request.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        },
                new HandlebarsTemplateEngine());

        get("/squad/new/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(req.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findById(1);
            newSquad.addSquadMembers(newMember);
            model.put("item", newMember.getName());
            model.put("newHero",newSquad.getName());
            return new ModelAndView(model, "success.hbs");
        },
                new HandlebarsTemplateEngine());
    }
}
