package pl.kara.bitbay.info.response;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;
import pl.kara.bitbay.currency.Currency;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
//TODO REFACTOR lepsza nazwy
//TODO REFACTOR wydzielić model od JSONDeserializer do pakietow
public final class Address {

    private final Currency currency;

    private final String walletAddress;

}
