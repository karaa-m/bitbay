package pl.kara.bitbay.info;

import pl.kara.bitbay.authentication.AuthenticationKeys;
import pl.kara.bitbay.info.request.AccountBalanceInformationRequest;
import pl.kara.bitbay.info.response.AccountBalanceInformationResponse;

/**
 * BitBay API 2.0
 * info - returns information about account balances
 * <p>
 * Input:
 * <p>
 * (optional)currency: currency shortcut if you want to display only specific balance (e.g. “BTC”)
 * Output:
 * <p>
 * currency: shortcut
 * available: amount of available money/cryptocurrency
 * locked: amount of locked money/cryptocurrency
 * <p>
 * TODO uzupelnic, ujednolicić i poprawić javadoci
 * TODO napisać test tego i zamockowac response od BITBAY !!!
 */
public interface AccountBalancesInformationClient {
    AccountBalanceInformationResponse findAccountBalancesInformationClient(final AccountBalanceInformationRequest request,
                                                                           final AuthenticationKeys authenticationKeys);
}
