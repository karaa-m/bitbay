## [![BitBay](http://kryptowalutownia.pl/filestore/logos/exchanges/BITBAY.png)](https://github.com/karaa-m/bitbay) Biblioteka BitBay API 2.0 w języku Java 8

Implementacja BitBay API 2.0 w jęzku Java. Biblioteka łączy się z giełdą BitBay korzystająć z udostępnionego API
w wersji 2.0 przez internet i pozwala na wykonywanie transakcji na giełdzie BitBay. Aktualna implementacja jest API
wersji prywatnej, bo pozwala na o wiele fajniejsze rzeczy, ale może uda się też zaimplementować API publiczne.
Bierzcie swoje UNIXy i Intellij IDEA i zaczynajcie kodować żebyśmy mogli trzepać na tym siano !!

## Jak wgle zacząć z kryptowalutami i BitBay i tą biblioteką ?

Pierwsze primo olej wszystkie kantory, bo ceny tam to zdzierstwo
(na giełdzie BitBay kupisz kryptowaluty o wiele taniej!)

Musisz zarejestrować się na giełde BitBay. Wchodzisz tam i się rejestrujesz.
Jak sie zalogujesz to w górnym prawym rogu klikasz na nazwę swojego konta i rozwinie Ci się takie menu z pozycjami typu:

![alt text](https://image.ibb.co/c0MF7G/jeden.png)

No i tutaj wchodzisz w Ustawienia API.

Potem na lewo masz przycisk "Add New Key" i w niego klikasz i dodajesz sobie klucz.

![alt text](https://image.ibb.co/kOkE1b/dwa.png)

![alt text](https://image.ibb.co/jynYuw/trzy.png)


I wgle żeby korzystać z tego klucza to nie musisz mieć zweryfikowanego konta na BitBay - jakieś podstawowe rzeczy
już możesz robić, ale lepiej zweryfikuj sobie konto na BitBay. To trwa jakieś 2 dni zanim będziesz mógł szaleć na BitBay
i oni używają dosyć wnikliwej weryfikacji - adres, skan prawa jazdy etc... , ale nie zrażaj się tym - gdyby
BitBay wzięło na twój dowod osobisty kredyt chwilówkę, to to i tak są grosze w porównaniu z tym co zarobisz na krypto.

 Dobra.
 
 Jak masz już ten klucz publiczny i prywatny to teraz możesz już skorzystać z biblioteki.
 Patrz w kolejne rozdziały.
 
## Podłączenie biblioteki - JAK URUCHOMIĆ
Jak zcheckoutujesz sobie to z githuba to po prostu walisz:  
```
./gradlew bootRun
```

i biblioteka powinna się już uruchomić i działać. O tym czy biblioteka działa poinformuje Cię muzyka w tle.
//TODO

## Podłączenie biblioteki - Przykad użycia

Ten klucz publiczny i prywatny, który sobie wygenerowałeś na BitBay to teraz będzie potrzebny.
Konstruujesz URLa na wzór tutaj mojego klucza publicznego / prywatnego i przykłądowo walisz zapytanie GETem:

```
curl "http://localhost:8080/info/LSK?publicKey=fcc08b5f-84a9-84a9-84a9-93bfd02d664a&privateKey=339c0774-339c-339c-339c-339c339c339c"
```

na wyjściu otrzymasz odpowiedź z biblioteki w stylu (REST jest po to, bo potem chce podłączyć pod to Gekko i inne rzeczy).

```
{
  "success" : true,
  "balances" : [ {
    "locked" : false,
    "available" : 0.00000388,
    "currency" : "LSK"
  } ],
  "addresses" : [ {
    "currency" : "BTC",
    "walletAddress" : "32Fg7n57qWV1t8dKA9u8CwJb23f6n2yvvU"
  }, {
    "currency" : "GAME",
    "walletAddress" : "GeHYU78WFdrGe3ne4Ee4RuUfTFesNRTqoZ"
  }, {
    "currency" : "BCC",
    "walletAddress" : "3LGp3UCRFvneAxgoN5D6ZYiD1bomHpNi1F"
  }, {
    "currency" : "BTG",
    "walletAddress" : "GXvNkpiZGBY1QQWzmUfdxf4m3NF2L4mv5H"
  }, {
    "currency" : "LSK",
    "walletAddress" : "17484407568686506030L"
  }, {
    "currency" : "ETH",
    "walletAddress" : "0xfdac638a3db1e0cc21fba8c2ed5b04a2a815f45a"
  }, {
    "currency" : "LTC",
    "walletAddress" : "LYydZbAKKXeb34mGeUAm4DjWh9okqxeAKE"
  }, {
    "currency" : "DASH",
    "walletAddress" : "XeiJGWL6xLZzqAbqnxaNiDgAzsWDxAtKTB"
  } ],
  "fee" : 0.43
}
```
//TODO opisać jak w wersji javowej korzystać z biblioteki

## O kodzie i technologiach technicznie

Biblioteka dostarcza podstawowy szkielet pozwalając tworzyć obiektowe mapowanie operacji na BitBay a następnie
bierze te obiekty, odpowiednio przetewarza i konstruuje odpowiednie żądanie HTTP do BitBay API 2.0.

Biblioteka nie posiada testów jednostkowych, bo nie ma na to czasu teraz.
Biblioteka posiada wysokiej jakości kod i korzysta z najnowszych sprawdzonych technologii.

Użyte technologie to gradle, Spring Boot, REST, Lombok, Guava, Apache Commons, może będzie Swagger do udokumentowania
i testowania API.


## Rozwój

Zadania porozrzucane są w formie komentarzy po całym kodzie.
* [X] TODO FEAUTRE -> ficzer / nowa funkcjonalność
* [X] TODO TEST -> przetestować / napisać test
* [X] TODO REFACTOR -> poprawienie kodu / zeby bylo czytelniej itd..

Priorytetowo w pierwszej kolejności zaimplementowane będą te moduły,
abyśmy mogli już grać botowo na giełdzie i zarabiać pieniądze na kryptowalutach czyli:

* [ ] TODO FEATURE szkielet i implementacja orderbook      //wersja 0.0.2
* [ ] TODO FEATURE szkielet i implementacja cancel         //wersja 0.0.4
* [ ] TODO FEATURE szkielet i implementacja trade          //wersja 0.0.6

### Maven

//TODO w przyszłości


### Co potem

Jak już większość będzie jest bot Gekko który gra. Do wystawianego REST API przez bibliotekę trzeba będzie podłączyć
bota Gekko (napisać konektor). Gekko jest pisany w JavaScript w node js bodajże i posiada już kilka konektorów, ale
nie konektora do BitBay.  Potem jak to będzie działać bierzemy strategie grania typu:

> https://github.com/askmike/gekko/issues/610
> https://github.com/askmike/gekko/issues/412

I jazda.

## DOTACJE

Potrzebuje hajsu na własne mieszkanie, możecie go wpłacać tutaj:

LSK Address: 4790646544144884441L

A jak nie chcecie wpłacać to nie musicie i można korzystać z bibliteki bez opłat i ograniczeń i tworzyć
własne biznesy, własne banki , własne BAŃKI i własne kantory i wszystko.

## Kontakt i info

https://4programmers.net/Profile/57121
https://4programmers.net/Forum/1431760



Z Bogiem.
