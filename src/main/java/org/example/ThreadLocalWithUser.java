package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLocalWithUser  implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalWithUser.class);
    private static final ThreadLocal<User> userThread = new ThreadLocal<>();
    private final Integer userId;
    private UserRepository userRepository = new UserRepository();

    public ThreadLocalWithUser(Integer userId) {
        this.userId = userId;
    }
    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserID(userId);
        userThread.set(new User(userName));
        LOGGER.info("Thread context for given userID: " + userId+ " is: "+ userThread.get());
    }
}
