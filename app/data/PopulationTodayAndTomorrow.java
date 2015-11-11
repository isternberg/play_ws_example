package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PopulationTodayAndTomorrow {

    public List<Population> total_population = new ArrayList<>();

    public static PopulationTodayAndTomorrow fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, PopulationTodayAndTomorrow.class);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.error("Could not deserialize population", e);
            return new PopulationTodayAndTomorrow();
        }
    }

}
