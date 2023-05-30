import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    //Every Branch method test
    @Test
    public void test4_1() {
        User user = null;
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    public void test4_2() {
        User user = new User(null, "short", "user@example.com");
        List<User> allUsers = Arrays.asList(
                new User(null, "short", "user@example.com")
        );
        Assertions.assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    public void test4_3() {
        User user = new User("newUser", "password123", "user@email.com");
        List<User> allUsers = Arrays.asList(
                new User("existingUser", "password123", "existingUser@email.com")
        );
        Assertions.assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    public void test4_4() {
        User user = new User("newUser", "password 123", "invalid-email");
        List<User> allUsers = Arrays.asList(
                new User("existingUser", "password123", "existing@email.com")
        );
        Assertions.assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    public void test4_5() {
        User user = new User("newUser", "specialPassword!", "newuser@email.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertTrue(SILab2.function(user, allUsers));
    }

    //Multiple Condition method test
    @Test
    public void test5_1(){
        User user = null;
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    public void test5_2(){
        User user = new User("username", null, "example@email.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    public void test5_3(){
        User user = new User("username", "password", null);
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
    }

    @Test
    public void test5_4(){
        User user = new User("username", "password", "example@email.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertFalse(SILab2.function(user, allUsers));
    }
}
