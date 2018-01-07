package pl.kara.bitbay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * BitBay API 2.0 implementacja w Java 8
 * <p>
 * https://bitbay.net/pl/api-prywatne
 * <p>
 * https://bitbay.net/pl/api-publiczne
 * <p>
 * API publiczne na koniec - prywatne jest bardziej użyteczne ;]
 * <p>
 * PROTIP:  przy tworzeniu obiektow mapujac jsona można sobie pomagać: http://www.jsonschema2pojo.org/
 */
@Slf4j
@SpringBootApplication
public class BitbayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitbayApplication.class, args);
    }

    /*
     * Zadania porozrzucane są w formie komentarzy po całym kodzie
     * TODO FEAUTRE -> ficzer / nowa funkcjonalność
     * TODO TEST -> przetestować / napisać test
     * TODO REFACTOR -> poprawienie kodu / zeby bylo czytelniej itd..
     * TODO BUG -> BUG / problem / mozliwe ze bedzie z tego BUG
     *
     *
     * Priorytetowo w pierwszej kolejności zapimplementować te moduły żeby można było
     * grać botem na giełdzie czyli:
     *
     *
     * TODO FEATURE szkielet i implementacja orderbook      //wersja 0.0.2
     * TODO FEATURE szkielet i implementacja cancel         //wersja 0.0.4
     * TODO FEATURE szkielet i implementacja trade          //wersja 0.0.6
     *
     * potem reszta..
     *
     * TODO TESTY modulu info
     * TODO uzupelnic javadocs
     * TODO FEATURE szkielet i implementacja orders
     * TODO FEATURE szkielet i implmentacja transfer
     * TODO FEAUTRE szkielet i implementacja withdraw
     * TODO FEAUTRE szkielet i implementacja history
     * TODO FEATURE szkielet i implementacja transactions
     *
     * TODO FEATURE metoda zamykająca kontekst i aplikację. zwolnić wszystkie połączenia
     *
     * //TODO FEATURE obsługa błędów walidacji i takich tam
     // i zwracanie odpowiedzi, jakiś GlobalExceptionHandler albo coś w tym stylu
     *
     *
     * TODO FEATURE obsluga ERROR CODES BitBay
     */

}
