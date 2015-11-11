package controllers;

import com.google.inject.Inject;
import helpers.JsonParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;


public class Application extends Controller {
    public static final String URL = "http://api.population.io/1.0/population/Israel/today-and-tomorrow/";


    @Inject
    JsonParser parser;


    public Result render() {
        List<Integer> populationData = parser.getPopulationData(URL);
        return ok(index.render(populationData));
    }

}
