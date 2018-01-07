package pl.kara.bitbay.info.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;
import pl.kara.bitbay.currency.Currency;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
//TODO BUG dwa with ?  - co sie stanie
@AllArgsConstructor(staticName = "with")
public final class AccountBalanceInformationRequest {

    private final Currency currency;

}
