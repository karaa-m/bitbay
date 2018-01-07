package pl.kara.bitbay.info.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import pl.kara.bitbay.currency.Currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

//TODO REFACTOR klasa do poprawy
//TODO TEST mechanizm do przetestowania i poprawy
final class JSONDeserializer extends JsonDeserializer<AccountBalanceInformationResponse> {

    /*
     *
     * Ten json deserializer powstal dlatego ze output zwracany przez bitbay nie jest
     * dobrym jsonem i trzeba stosowac takie tricki. mozliwe ze nie wszystkie odpowiedzi
     * od bitbay sa w zlym jsonie i przy niektorych modulach automatyczne mapowanie wystarczy i nie trzeba
     * bedzie robic tego
     *
     *
     */


    @Override
    public AccountBalanceInformationResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        final JsonNode root = p.getCodec().readTree(p);
        final boolean success = root.get("success").asBoolean();

        ImmutableList.Builder<AccountBalanceInformation> balancesBuilder = ImmutableList.builder();
        ImmutableList.Builder<Address> addressBuilder = ImmutableList.builder();
        Iterator<Map.Entry<String, JsonNode>> balances = root.get("balances").fields();

        while (balances.hasNext()) {
            balancesBuilder.add(mapAccountBalanceInformation(balances.next()));
        }

        Iterator<Map.Entry<String, JsonNode>> addresses = root.get("addresses").fields();

        while (addresses.hasNext()) {
            addressBuilder.add(mapWalletAddresses(addresses.next()));
        }//TODO REFACTOR wydzielić do metod

        String fee = root.get("fee").asText(); //TODO REFACTOR nazwy pol do przemyslenia

        return AccountBalanceInformationResponse.with()
                .success(success)
                .balances(balancesBuilder.build())
                .fee(new BigDecimal(fee)) //TODO REFACTOR moze jakis mapper?
                .addresses(addressBuilder.build())
                .build();
    }

    //TODO REFACTOR wydzielic te metody do osobnych klas jak juz
    private AccountBalanceInformation mapAccountBalanceInformation(Map.Entry<String, JsonNode> balance) {
        final String currencyName = balance.getKey();
        final JsonNode availableAndLocked = balance.getValue();

        return AccountBalanceInformation.with()
                .currency(Currency.valueOf(currencyName))
                //TODO REFACTOR wyciagnij nazwy pol do stalych
                .available(new BigDecimal(availableAndLocked.get("available").asText())) //TODO lepszy mapper
                .locked(availableAndLocked.get("locked").asBoolean())
                .build();
    }

    private Address mapWalletAddresses(Map.Entry<String, JsonNode> addresses) {
        final String currencyName = addresses.getKey();
        final JsonNode address = addresses.getValue();

        return Address.with()
                .currency(Currency.valueOf(currencyName))
                .walletAddress(address.asText())
                .build();
    }
}
