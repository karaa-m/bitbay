package pl.kara.bitbay.info.response;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;
import pl.kara.bitbay.currency.Currency;

import java.math.BigDecimal;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
//TODO FEATURE czy tych klas nie wydzielic do osobnego modulu - modelu ?
public final class AccountBalanceInformation {

    private final Boolean locked;

    //TODO zastąpić JODA MONEY ?
    private final BigDecimal available;

    //TODO MoneyUnit ?
    private final Currency currency;

}
