package pl.kara.bitbay.api_caller.engine.url;

/**
 * Tworzy adres URL pod ktory nalezy wyslac POSTa do BitBay z podanym BitBayPostBody
 */
public final class BitBayPostUrlCreator {

    private static final String API_URL = "https://bitbay.net/API/Trading/tradingApi.php";

    private static final String BODY_POST_SEPARATOR = "?";

    public static String fromPostBody(final String bitBayPostBody) {
        return API_URL + BODY_POST_SEPARATOR + bitBayPostBody;
    }

}
