package de.gernotpointner.dummycoffeedetector;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StatisticsObserver implements Observer<String> {

    private final Map<URL, Integer> urlCounts = new HashMap<>();
    @Override
    public void onSubscribe(Disposable disposable) {
        log("OnSubscribe: " + disposable);

    }

    @Override
    public void onNext(String s) {
        log("OnNext: " + s);
        try {
            URL url = new URL(s);
            if(urlCounts.containsKey(url)){
                urlCounts.put(url, urlCounts.get(url) + 1);
            } else {
                urlCounts.put(url, 1);
            }

            urlCounts.forEach((key, value) -> System.out.println(key + " : " + value));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log("OnError: " + throwable);
    }

    @Override
    public void onComplete() {
        log("OnComplete");
    }

    private void log(String message){
        System.out.println("[STATISTICS]: " + message);
    }
}
