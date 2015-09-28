/**
 * Created by Kostya Goloveshko on 28.09.2015.
 */
package com.company;

import java.util.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MergeTest {
    @Test
    public void mergeTwoNonEmptyLists() {
        ArrayList<String> mergedList =
            Main.mergeTwoSortedLists(new ArrayList<String>(Arrays.asList("1","3","4")),
                                     new ArrayList<String>(Arrays.asList("2","5","7")));
        assertEquals(new ArrayList<String>(Arrays.asList("1","2","3","4","5","7")), mergedList);
    }

    @Test
    public void mergeTwoEmptyLists() {
        ArrayList<String> mergedList =
                Main.mergeTwoSortedLists(new ArrayList<String>(),
                                         new ArrayList<String>());
        assertEquals(new ArrayList<String>(), mergedList);
    }

    @Test
    public void mergeListsWithSameValues() {
        ArrayList<String> mergedList =
                Main.mergeTwoSortedLists(new ArrayList<String>(Arrays.asList("1","1","1","3")),
                                         new ArrayList<String>(Arrays.asList("-4","1","1","1","3")));
        assertEquals(new ArrayList<String>(Arrays.asList("-4","1","1","1","1","1","1","3","3")), mergedList);
    }
}
