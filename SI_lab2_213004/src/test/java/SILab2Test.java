import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private User user;
    private List<User> allUsers = new ArrayList<>();

    @Test
    void everyBranchTest() {

        // test 1
        this.user = null;
        this.allUsers.clear();

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // test 2
        this.user = new User("name", "!password", "@.");
        this.allUsers.add(user);

        assertFalse(SILab2.function(user, allUsers));

        // test 3
        user = new User("name", "password", "@.");
        this.allUsers.clear();
        this.allUsers.add(new User("name2", "password", "2@."));

        assertFalse(SILab2.function(user, allUsers));

        // test 4
        this.user = new User(null, "pass", "email");

        assertFalse(SILab2.function(user, allUsers));

        // test 5
        this.user = new User(null, "pass word", "email");

        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void multipleConditionTest() {

        // test 1
        this.user = new User("name", "pass", "email");

        assertFalse(SILab2.function(user, allUsers));

        // test 2
        this.user = new User("name", "pass", null);

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // test 3
        this.user = new User("name", null, "email");

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // test 4
        this.user = null;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        
    }
}