package pl.kara.bitbay.api_caller.engine.body_creator.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.kara.bitbay.api_caller.BitBayClient;
import pl.kara.bitbay.api_caller.engine.body_creator.PostBodyCreator;

/**
 * Tworzy kompletne ciało requestu POST na BitBay, które potem będzie zahashowane i też w URLu
 * na który będzie POST. Najpierw ładuje obowiązkowy prefix z method i moment
 */
@Slf4j
@AllArgsConstructor
final class PostBodyCreatorImpl implements PostBodyCreator {

    private static final String SEPARATOR = "&";

    private static final String KEY_VALUE_SEPARATOR = "=";

    private final BitBayClient client;

    public String createBitBayBody(final ImmutableMap<String, String> fieldNameToValueMap) {
        return Joiner.on(SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(prepareAllBodyParams(fieldNameToValueMap));
    }

    private ImmutableMap<String, String> prepareAllBodyParams(final ImmutableMap<String, String> fieldNameToValueMap) {
        return ImmutableMap.<String, String>builder()
                .putAll(BodyBaseFactory.createBodyBase(client))
                .putAll(fieldNameToValueMap)
                .build();
    }


}
