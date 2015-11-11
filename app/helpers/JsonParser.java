package helpers;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.libs.Json;
import services.PopulationService;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    @Inject
    PopulationService populationService;

    public List<Integer> getPopulationData(String url){
        List<Integer> populationCount = new ArrayList<>();
        JsonNode populationData = populationService.getPopulationData(url);
        String today =(Json.fromJson(populationData.get("total_population").get(0).get("population"), String.class));
        String tomorrow =(Json.fromJson(populationData.get("total_population").get(1).get("population"), String.class));
        populationCount.add(Integer.parseInt(today));
        populationCount.add(Integer.parseInt(tomorrow));
        populationCount.add(Integer.parseInt(tomorrow) - Integer.parseInt(today));

        return populationCount;
    }


}
