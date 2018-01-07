package pl.kara.bitbay.api_caller;

import org.springframework.http.ResponseEntity;
import pl.kara.bitbay.authentication.AuthenticationKeys;

/**
 * Publiczne API BitBayRequestExecutor - executora ktory strzela HTTP POST do BitBay.
 * Przyjmuje wygodne obiekty i tworzy odpowiednie zapytanie do BitBay.
 */
public interface BitBayRequestExecutor {
    <T> ResponseEntity<T> post(final Object postObject, final AuthenticationKeys authenticationKeys, final Class<T> returnType);
}
