package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedWithUser implements Runnable {

    public static Map<Integer, User> userPerId = new ConcurrentHashMap<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    public SharedWithUser(int i) {
        this.userId = i;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserID(userId);
        userPerId.put(userId, new User(userName));
    }
}
