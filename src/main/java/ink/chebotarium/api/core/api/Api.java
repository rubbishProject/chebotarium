package ink.chebotarium.api.core.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Api {

    private static final String VERSION_1 = "/v1";
    private static final String API_PREFIX = "/api";
    public static final String API_VERSION_1 = API_PREFIX + VERSION_1;
}
