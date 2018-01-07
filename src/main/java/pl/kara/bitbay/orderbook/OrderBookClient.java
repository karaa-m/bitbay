package pl.kara.bitbay.orderbook;

import pl.kara.bitbay.orderbook.request.OrderBookRequest;

//TODO FEATURE szkielet i implementacja orderbook
public interface OrderBookClient {

    String listOfAllOpenOffersAtTheStockMarket(OrderBookRequest request);

}
