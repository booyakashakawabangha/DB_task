package scrapper;

public class Main {
    public static void main(String[] args) {
        DefaultScrapper defaultScrapper = new DefaultScrapper();
        String url = "https://www.newhomesource.com/specdetail/130-victoria-peak-loop-dripping-springs-tx-78620/2108550";
        System.out.println(defaultScrapper.parse(url));
    }
}
