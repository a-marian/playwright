package org.example;

import java.util.UUID;

public class UserRepository {
    String getUserNameForUserID(int userId){
        return UUID.randomUUID().toString();
    }
}
