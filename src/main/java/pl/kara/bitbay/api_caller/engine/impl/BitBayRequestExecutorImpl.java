package pl.kara.bitbay.api_caller.engine.impl;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.kara.bitbay.api_caller.BitBayRequestExecutor;
import pl.kara.bitbay.api_caller.engine.url.BitBayPostUrlCreator;
import pl.kara.bitbay.api_caller.request.BitBayHttpRequestFactory;
import pl.kara.bitbay.authentication.AuthenticationKeys;
import pl.kara.bitbay.reflection.FieldStringValueExtractor;
import pl.kara.bitbay.api_caller.engine.body_creator.PostBodyCreator;
import pl.kara.bitbay.authentication.Authenticator;

/**
 * Klasa ktora mapuje przesyłane obiekty i docelowo wykonuje request
 */
@Slf4j
@AllArgsConstructor
public final class BitBayRequestExecutorImpl implements BitBayRequestExecutor {

    private final RestTemplate restTemplate;

    private final Authenticator authenticator;

    private final PostBodyCreator postBodyCreator;

    @Override
    public <T> ResponseEntity<T> post(final Object postObject, final AuthenticationKeys authenticationKeys, final Class<T> returnType) {
        final ImmutableMap<String, String> fieldNamesWithValues = FieldStringValueExtractor.fieldNamesWithValues(postObject);
        final String bitBayBody = postBodyCreator.createBitBayBody(fieldNamesWithValues);
        final String bitBayPostURL = BitBayPostUrlCreator.fromPostBody(bitBayBody);
        final String signedAPIHash = authenticator.signPostBody(bitBayBody, authenticationKeys);
        final HttpEntity<MultiValueMap<String, String>> request = BitBayHttpRequestFactory.createRequest(signedAPIHash, authenticationKeys);
        final ResponseEntity<T> responseFromBitBay = restTemplate.postForEntity(bitBayPostURL, request, returnType);

        //TODO BUG dlaczego to nie dziala ?
        //TODO logowac debug response bo lepiej sie pisze
//        log.info("Response BODY from BitBay API:",responseFromBitBay.getBody());
//        log.info("Response Headers from BitBay API:",responseFromBitBay.getHeaders());

        return responseFromBitBay;
    }

}
