package pl.kara.bitbay.api_caller.engine.factory.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kara.bitbay.api_caller.BitBayRequestExecutor;
import pl.kara.bitbay.api_caller.engine.factory.BitBayRequestExecutorFactory;
import pl.kara.bitbay.api_caller.BitBayClient;
import pl.kara.bitbay.api_caller.engine.body_creator.impl.PostBodyCreatorFactory;
import pl.kara.bitbay.api_caller.engine.impl.BitBayRequestExecutorImpl;
import pl.kara.bitbay.authentication.Authenticator;

@Slf4j
@Component
public class BitBayRequestExecutorFactoryImpl implements BitBayRequestExecutorFactory {

    private final RestTemplate restTemplate;

    private final Authenticator authenticator;

    @Autowired
    private BitBayRequestExecutorFactoryImpl(RestTemplate restTemplate, Authenticator authenticator) {
        this.restTemplate = restTemplate;
        this.authenticator = authenticator;
    }

    @Override
    public BitBayRequestExecutor createFor(final BitBayClient client) {
        return new BitBayRequestExecutorImpl(restTemplate, authenticator, PostBodyCreatorFactory.createFor(client));
    }

}
