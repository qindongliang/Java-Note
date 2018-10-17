package concurrent.async;

import java.util.concurrent.CompletableFuture;

import static junit.framework.TestCase.assertTrue;

public class AsyncTaskTest {

    public static void main(String[] args) {

//        https://juejin.im/post/5adbf8226fb9a07aac240a67
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s ->result.append(s));
//        assertTrue("Result was empty", result.length() > 0);


        System.out.println(result.toString());

    }
}
