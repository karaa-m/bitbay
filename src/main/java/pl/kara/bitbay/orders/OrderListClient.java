package pl.kara.bitbay.orders;

import pl.kara.bitbay.orders.request.OrderListRequest;
import pl.kara.bitbay.orders.response.OrderListResponse;

//TODO FEATURE szkielet i implementacja orders
public interface OrderListClient {

    OrderListResponse findOrderList(OrderListRequest orderListRequest);

}
