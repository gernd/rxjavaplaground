package de.gernotpointner.dummycoffeedetector;

import io.reactivex.Observable;
import javafx.beans.InvalidationListener;

public class DummyCrawler{

    public Observable<String> getObserver(){
        return Observable.create(observerEmitter -> observerEmitter.onNext("http://www.gernd.de"));
    }
}

