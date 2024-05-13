import org.example.SharedWithUser;
import org.example.ThreadLocalWithUser;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadLocalTesting {

    @Test
    public void givenThreadThatStoresContextInAMap_whenStartThread_thenShouldSetContextForBothUsers()
            throws ExecutionException, InterruptedException {
        //when
        SharedWithUser first = new SharedWithUser(1);
        SharedWithUser second = new SharedWithUser(2);

        new Thread(first).start();
        new Thread(second).start();
        Thread.sleep(3000);

        assertEquals(SharedWithUser.userPerId.size(), 2);
    }

    @Test
    public void givenThreadThatStoresContextInThreadLocal_whenStartThread_thenShouldStoreContextInThreadLocal() throws ExecutionException, InterruptedException {
        //when
        ThreadLocalWithUser firstUser = new ThreadLocalWithUser(1);
        ThreadLocalWithUser secondUser = new ThreadLocalWithUser(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        Thread.sleep(3000);

    }
}
