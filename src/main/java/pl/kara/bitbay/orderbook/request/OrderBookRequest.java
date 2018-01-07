package pl.kara.bitbay.orderbook.request;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;
import pl.kara.bitbay.currency.Currency;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
public final class OrderBookRequest {

    //TODO FEATURE moze jakas adnotacja zeby nie trzeba bylo durnych nazw zmiennych robic?
    private final Currency order_currency;

    private final Currency payment_currency;

}
