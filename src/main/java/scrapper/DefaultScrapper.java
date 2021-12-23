package scrapper;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DefaultScrapper implements Scrapper{

    @Override @SneakyThrows
    public Home parse(String url) {
        Document doc = Jsoup.connect(url).get();
        Element priceTag = doc.selectFirst("detail__info-xlrg");
        Element bedTag = doc.selectFirst("nhs_BedsInfo");
        Element bathTag = doc.selectFirst("nhs_BedsInfo");
        Element garageTag = doc.selectFirst("nhs_BedsInfo");
        System.out.println(doc);

        return null;
    }
}
