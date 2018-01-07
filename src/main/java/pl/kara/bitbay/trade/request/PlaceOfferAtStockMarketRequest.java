package pl.kara.bitbay.trade.request;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;
import pl.kara.bitbay.currency.Currency;

import java.math.BigDecimal;

//TODO FEATURE szkielet i implementacja trade
//looknij na exchange

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
public class PlaceOfferAtStockMarketRequest {

    private final Currency currency;

    private final BigDecimal amount;

    private final OrderType type;

    private final Currency payment_currency;

    private final BigDecimal rate;

}
