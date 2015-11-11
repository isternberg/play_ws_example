package services;

import data.PopulationTodayAndTomorrow;
import play.libs.F;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;

public class RestPopulationService implements PopulationService {

    private final int BLOCK_TIMEOUT = 10000;

    @Inject
    private WSClient ws;

    @Override
    public PopulationTodayAndTomorrow getPopulationData(String url) {
        F.Promise<WSResponse> wsResponsePromise = ws.url(url).get();
        WSResponse wsResponse = wsResponsePromise.get(BLOCK_TIMEOUT);
        return PopulationTodayAndTomorrow.fromJson(wsResponse.getBody());

    }


}
