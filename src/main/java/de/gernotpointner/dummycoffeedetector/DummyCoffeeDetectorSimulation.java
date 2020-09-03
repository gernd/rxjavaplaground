package de.gernotpointner.dummycoffeedetector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DummyCoffeeDetectorSimulation {

    public static void main(String[] args) {


        var dummyCrawler = new DummyCrawler();
        var dummyCrawlerObservable =
                dummyCrawler.getObserver()
                        .doAfterNext(s -> System.out.println("After next for " + s))
                        .delay(1, TimeUnit.SECONDS)
                        .repeat();


        var crawlerPipeline = dummyCrawlerObservable
                .map(DummyCoffeeDetectorSimulation::normalizeUrl)
                .map(DummyCoffeeDetectorSimulation::availableHttpOptions)
                .filter(optionsList -> optionsList.contains("BREW"));

        // set up statistics
        var statistics = new StatisticsObserver();
        dummyCrawlerObservable.subscribe(statistics);

        crawlerPipeline.blockingSubscribe(result -> System.out.println("Result is " + result));
    }


    private static String normalizeUrl(String url){
        System.out.println("Normalizing url " + url);
        return "normalized " + url;
    }

    private static List<String> availableHttpOptions(String url){
        List<String> options =
        (new Random().nextInt() % 2 != 0) ?
               Collections.singletonList("BREW") : Arrays.asList("GET", "POST");
        return options;
    }


}
