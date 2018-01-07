package pl.kara.bitbay.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public final class UnixTimestampUtils {

    public static long nowUnixTimestamp() {
        //TODO FEAUTRE - sprawdzić strefe czasową dla serwera BitBay i uniezależnić to od system default
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
    }

}
