package pl.kara.bitbay.api_caller.engine.body_creator.impl;

import com.google.common.collect.ImmutableMap;
import pl.kara.bitbay.api_caller.BitBayClient;
import pl.kara.bitbay.utils.UnixTimestampUtils;

/**
 * Tworzy podstawowy prefix w ciele requestu POST na BitBay ktory musi zawierac method i moment
 * <p>
 * pamietaj, że moment:
 * <p>
 * It is request execution unix timestamp. This value is compared with server time. If difference is bigger than 5
 * seconds - operation won’t be executed. It is important to have synchronized time with NTP public time server -
 * in other case server time can differ a lot than time of request machine.
 */
final class BodyBaseFactory {

    private static final String METHOD_PARAM_NAME = "method";

    private static final String MOMENT_PARAM_NAME = "moment";

    static ImmutableMap<String, String> createBodyBase(final BitBayClient forBitBayClient) {
        return ImmutableMap.of(
                METHOD_PARAM_NAME, forBitBayClient.getMethodName(),
                MOMENT_PARAM_NAME, String.valueOf(UnixTimestampUtils.nowUnixTimestamp())
        );
    }

}
