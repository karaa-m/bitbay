package pl.kara.bitbay.info.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.kara.bitbay.api_caller.BitBayRequestExecutor;
import pl.kara.bitbay.api_caller.engine.factory.BitBayRequestExecutorFactory;
import pl.kara.bitbay.authentication.AuthenticationKeys;
import pl.kara.bitbay.info.AccountBalancesInformationClient;
import pl.kara.bitbay.info.response.AccountBalanceInformationResponse;
import pl.kara.bitbay.api_caller.BitBayClient;
import pl.kara.bitbay.info.request.AccountBalanceInformationRequest;

@Component
final class AccountBalancesInformationClientImpl implements BitBayClient, AccountBalancesInformationClient {

    private final BitBayRequestExecutor requestExecutor;

    @Autowired
    AccountBalancesInformationClientImpl(BitBayRequestExecutorFactory bitBayRequestExecutorFactory) {
        this.requestExecutor = bitBayRequestExecutorFactory.createFor(this);
    }

    @Override
    public AccountBalanceInformationResponse findAccountBalancesInformationClient(final AccountBalanceInformationRequest request, final AuthenticationKeys authenticationKeys) {
        ResponseEntity<AccountBalanceInformationResponse> post = requestExecutor.post(request, authenticationKeys, AccountBalanceInformationResponse.class);
        return post.getBody();
    }

    @Override
    public String getMethodName() {
        return "info"; //TODO REFACTOR wydzielić do stałej ?
    }
}
