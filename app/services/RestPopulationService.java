package services;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.libs.ws.WSClient;

import javax.inject.Inject;

public class RestPopulationService implements PopulationService {

    private final int CONNECTION_TIMEOUT = 10000;

    @Inject
    private WSClient ws;

    @Override
    public JsonNode getPopulationData(String url) {
        F.Promise<JsonNode> jsonPromise = ws.url(url).get().map(response -> response.asJson());
        return jsonPromise.get(CONNECTION_TIMEOUT);
    }


}
