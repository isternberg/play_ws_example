package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

@ImplementedBy(RestPopulationService.class)
public interface PopulationService {
    public JsonNode getPopulationData(String url);
}
