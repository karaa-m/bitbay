package pl.kara.bitbay.api_caller.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.kara.bitbay.authentication.AuthenticationKeys;

/**
 * Tworzy docelowy request z odpowiednimi nagłowkami do BitBay.
 * Wymaga podania klucza i zahaszowanego body
 */
public final class BitBayHttpRequestFactory {

    private static final String API_HASH_PARAM_NAME = "API-Hash";

    private static final String API_PUBLIC_KEY_PARAM_NAME = "API-Key";

    public static HttpEntity<MultiValueMap<String, String>> createRequest(final String signedApiHash,
                                                                          final AuthenticationKeys authenticationKeys) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.add(API_HASH_PARAM_NAME, signedApiHash);
        headers.add(API_PUBLIC_KEY_PARAM_NAME, authenticationKeys.getPublicKey());

        return new HttpEntity<>(new LinkedMultiValueMap<String, String>(), headers);
    }


}
