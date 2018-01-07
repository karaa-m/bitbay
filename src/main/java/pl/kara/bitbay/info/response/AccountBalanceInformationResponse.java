package pl.kara.bitbay.info.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;

import java.math.BigDecimal;

@Data
@Value
@Wither
@Builder(builderMethodName = "with")
@JsonDeserialize(using = JSONDeserializer.class)
public final class AccountBalanceInformationResponse {

    private final Boolean success;//TODO czy moze byc maly boolean i czy warto?

    private final ImmutableList<AccountBalanceInformation> balances;

    private final ImmutableList<Address> addresses;

    private final BigDecimal fee; //TODO nazwy do przemyslenia i czy wprowadzac money albo joda money ?

}
