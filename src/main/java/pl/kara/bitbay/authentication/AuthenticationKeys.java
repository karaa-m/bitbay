package pl.kara.bitbay.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;

/**
 * Przechowuje klucz publiczny i prywatny do BitBay API
 */
@Value
@Wither
@Data
@Builder(builderMethodName = "with")
@AllArgsConstructor
public final class AuthenticationKeys {

    private final String publicKey;

    private final String privateKey;
}
