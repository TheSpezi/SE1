package org.hbrs.se1.ws25.exercises.uebung4_myVersion.tests;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.UserStoryException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.UserStory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserStoriesTest {

    static UserStory us1;
    static UserStory us2;
    static UserStory us3;

    @Test
    void grenzwerte() throws UserStoryException {
        assertDoesNotThrow(() -> us1 = new UserStory("Titel", "Akz", "Projekt", 1,1,1,1));
        assertDoesNotThrow(() -> us2 = new UserStory("Titel", "Akz", "Projekt", 5,5, 12345,5));
        assertThrows(UserStoryException.class,() -> us3 = new UserStory("Titel", "Akz", "Projekt", 0,0,0,0));
        assertThrows(UserStoryException.class,() -> us3 = new UserStory("Titel", "Akz", "Projekt", 6,6,-1,6));

    }

    @Test
    void negativerWert() throws UserStoryException {
        assertThrows(UserStoryException.class ,() -> us1 = new UserStory("Titel", "Akz", "Projekt", 1,1,Integer.MAX_VALUE,1));
    }
}
