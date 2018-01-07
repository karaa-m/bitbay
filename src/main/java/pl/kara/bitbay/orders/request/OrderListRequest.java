package pl.kara.bitbay.orders.request;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
public final class OrderListRequest {

    private final Integer limit;

}
