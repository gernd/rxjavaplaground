package de.gernotpointner;

import io.reactivex.Observable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Observable<String> observable = Observable.just("one", "two", "three");
        observable.subscribe(item -> System.out.println(item));
    }
}
