package scrapper;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class CacheScrapper implements Scrapper{

    @Override @SneakyThrows
    public Home parse(String url) {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        return null;
    }
}
