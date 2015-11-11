package services;

import com.google.inject.ImplementedBy;
import data.PopulationTodayAndTomorrow;

@ImplementedBy(RestPopulationService.class)
public interface PopulationService {
     PopulationTodayAndTomorrow getPopulationData(String url);
}
