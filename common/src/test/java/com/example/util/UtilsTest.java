package com.example.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilsTest {
    /**
     * Method under test: {@link Utils.PictureCategory#toString()}
     */
    @Test
    void testPictureCategoryToString() {
        assertEquals("living thing", Utils.PictureCategory.LIVING.toString());
        assertEquals("machine", Utils.PictureCategory.MACHINE.toString());
        assertEquals("nature", Utils.PictureCategory.NATURE.toString());
    }

    /**
     * Method under test: {@link Utils.PictureState#toString()}
     */
    @Test
    void testPictureStateToString() {
        assertEquals("accepted", Utils.PictureState.ACCEPTED.toString());
        assertEquals("rejected", Utils.PictureState.REJECTED.toString());
        assertEquals("unprocessed", Utils.PictureState.UNPROCESSED.toString());
    }
}

