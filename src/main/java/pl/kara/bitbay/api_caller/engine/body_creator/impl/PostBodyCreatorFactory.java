package pl.kara.bitbay.api_caller.engine.body_creator.impl;

import pl.kara.bitbay.api_caller.BitBayClient;
import pl.kara.bitbay.api_caller.engine.body_creator.PostBodyCreator;

public class PostBodyCreatorFactory {

    public static PostBodyCreator createFor(final BitBayClient bitBayClient) {
        return new PostBodyCreatorImpl(bitBayClient);
    }

}
