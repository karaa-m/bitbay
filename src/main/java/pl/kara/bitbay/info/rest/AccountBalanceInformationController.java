package pl.kara.bitbay.info.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kara.bitbay.authentication.AuthenticationKeys;
import pl.kara.bitbay.currency.Currency;
import pl.kara.bitbay.info.AccountBalancesInformationClient;
import pl.kara.bitbay.info.request.AccountBalanceInformationRequest;
import pl.kara.bitbay.info.response.AccountBalanceInformationResponse;

import static pl.kara.bitbay.info.rest.AccountBalanceInformationController.PATH;

@Slf4j
@RestController
@RequestMapping(PATH)
public final class AccountBalanceInformationController {

    public static final String PATH = "/info/{currency}";

    private final AccountBalancesInformationClient accountBalancesInformationClient;

    @Autowired
    AccountBalanceInformationController(AccountBalancesInformationClient accountBalancesInformationClient) {
        this.accountBalancesInformationClient = accountBalancesInformationClient;
    }

    @GetMapping
    public AccountBalanceInformationResponse getAccountBalanceInformations(
            @PathVariable(required = false) final Currency currency, final AuthenticationKeys authenticationKeys) {
        //TODO TEST co jak nie poda currency sie stanie ?
        //TODO TEST co jak nie poda autgenticationKeys
        //TODO FEAUTRE opcja default authenticationKeys
        final AccountBalanceInformationRequest request = AccountBalanceInformationRequest.with(currency);
        return accountBalancesInformationClient.findAccountBalancesInformationClient(request, authenticationKeys);
    }

    //TODO FEATURE obsługa błędów walidacji i takich tam
    // i zwracanie odpowiedzi, jakiś GlobalExceptionHandler albo coś w tym stylu

}
