import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

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


    }
}
