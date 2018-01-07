package pl.kara.bitbay.authentication;

/**
 * Zajmuje sie odpowiednim zahashowaniem ciała requestu POST na BitBay zgodnie z ich wymaganiami
 */
public interface Authenticator {
    String signPostBody(final String bitBayPostBody, final AuthenticationKeys authenticationKeys);
}
