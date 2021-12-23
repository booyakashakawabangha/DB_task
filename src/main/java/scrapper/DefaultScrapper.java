package scrapper;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DefaultScrapper implements Scrapper{
    private static final String PRICE_TAG = ".detail__info-xlrg";
    private static final String BED_TAG = ".nhs_BedsInfo";
    private static final String BATH_TAG = ".nhs_BedsInfo";
    private static final String GARAGE_TAG = ".nhs_BedsInfo";

    @Override @SneakyThrows
    public Home parse(String url) {
        Document doc = Jsoup.connect(url).get();
        int price = getPrice(doc);
        double beds = getBeds(doc);
        double bathes = getBathes(doc);
        double garages = getGarages(doc);
        return new Home(price, beds, bathes, garages);
    }

    private int getPrice(Document doc) {
        String price = doc.selectFirst(PRICE_TAG).text().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    private double getBeds(Document doc) {
        String beds = doc.selectFirst(BED_TAG).text().replaceAll("[^,0-9]", "");
        return Double.parseDouble(beds);
    }

    private double getBathes(Document doc) {
        String bathes = doc.selectFirst(BATH_TAG).text().replaceAll("[^,0-9]", "");
        return Double.parseDouble(bathes);
    }

    private double getGarages(Document doc) {
        String garages = doc.selectFirst(GARAGE_TAG).text().replaceAll("[^,0-9]", "");
        return Double.parseDouble(garages);
    }
}

