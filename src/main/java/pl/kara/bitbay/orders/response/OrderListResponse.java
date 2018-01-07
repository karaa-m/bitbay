package pl.kara.bitbay.orders.response;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
public final class OrderListResponse {


}
