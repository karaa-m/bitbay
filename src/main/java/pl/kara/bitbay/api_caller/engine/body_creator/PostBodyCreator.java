package pl.kara.bitbay.api_caller.engine.body_creator;

import com.google.common.collect.ImmutableMap;

public interface PostBodyCreator {
    String createBitBayBody(final ImmutableMap<String, String> fieldNameToValueMap);
}
