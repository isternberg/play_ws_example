package controllers;

import com.google.inject.Inject;
import data.PopulationTodayAndTomorrow;
import play.mvc.Controller;
import play.mvc.Result;
import services.PopulationService;
import views.html.index;


public class Application extends Controller {
    public static final String URL = "http://api.population.io/1.0/population/Israel/today-and-tomorrow/";

;

    @Inject
    PopulationService populationService;


    public Result render() {
        PopulationTodayAndTomorrow populationData = populationService.getPopulationData(URL);
        return ok(index.render(populationData));
    }

}
