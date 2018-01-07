package pl.kara.bitbay.authentication.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Component;
import pl.kara.bitbay.authentication.AuthenticationKeys;
import pl.kara.bitbay.authentication.Authenticator;

@Slf4j
@Component
final class AuthenticatorImpl implements Authenticator {

    private static final HmacAlgorithms HMAC_BITBAY_ALGORITHM = HmacAlgorithms.HMAC_SHA_512;

    @Override
    public String signPostBody(final String bitBayPostBody, final AuthenticationKeys authenticationKeys) {
        final HmacUtils hmacUtils = createHmacUtilsForPrivateKey(authenticationKeys);
        return hmacUtils.hmacHex(bitBayPostBody);
    }

    private HmacUtils createHmacUtilsForPrivateKey(final AuthenticationKeys authenticationKeys) {
        return new HmacUtils(HMAC_BITBAY_ALGORITHM, authenticationKeys.getPrivateKey());
    }
}
