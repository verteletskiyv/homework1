package part2;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortStringListTest {
    private static List<String> listRandom, listWithNull, listEmptyString, listEmpty;

    @BeforeAll
    public static void setUpInputs() {
        listRandom = List.of("You should try these good #Hashtag in your Instagram or #Tiktok post to get #popular and boost your view",
                "Check out Jane Doe's new #Instagram!",
                "bla-#bla-bla-bla-#bla #java",
                "#java #Instagram Hashtag",
                "#java #research #uxdesigning #js #HTML #uxlife #LoremIpsum #womeninux #react #uxdesignmastery",
                "#js #uixsupply #uxdesign #mobileappdesign #react #userinterface #dribbble #uiux #java #js",
                "#LoremIpsum dolor #js sit amet, c#onsectetur");
        listWithNull = Arrays.asList("#LoremIpsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.", null,
                "Многие #java программы электронной #JS вёрстки и редакторы #HTML используют #LoremIpsum в качестве текста по умолчанию",
                "Best Popular #Hashtag to use with #LoremIpsum are #graphicarts #HTML #JS", null,
                "#java #java #JS #LoremIpsum #JS #react #graphicdesignThe #posterdesign #poster #graphicdesign",
                "bla-#bla-bla-bla-#bla", null, "234567 987654 #%6789 @*&#^ 67891 !&@#*!");
        listEmptyString = List.of("");
        listEmpty = new ArrayList<>();
    }

    @Test()
    public void top5ShouldThrowNPEifInputIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> SortStringList.top5Tags(null));
        assertTrue(exception.getMessage().contains("\"inputList\" is null"));
    }

    @Test
    public void top5ShouldNotReturnNullHavingNonNullInput() {
        assertNotNull(SortStringList.top5Tags(listRandom));
        assertNotNull(SortStringList.top5Tags(listWithNull));
        assertNotNull(SortStringList.top5Tags(listEmptyString));
        assertNotNull(SortStringList.top5Tags(listEmpty));
    }

    @Test
    public void top5ShouldReturnAMapWith5MostCommonHashTagsOfAGivenListOfStrings() {
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#java", 4L);
        expected.put("#js", 3L);
        expected.put("#LoremIpsum", 2L);
        expected.put("#react", 2L);
        expected.put("#HTML", 1L);
        assertEquals(expected, SortStringList.top5Tags(listRandom));
        expected.clear();

        expected.put("#LoremIpsum", 4L);
        expected.put("#JS", 3L);
        expected.put("#HTML", 2L);
        expected.put("#java", 2L);
        expected.put("#react", 1L);
        assertEquals(expected, SortStringList.top5Tags(listWithNull));

        expected = new HashMap<>();
        assertEquals(expected, SortStringList.top5Tags(listEmptyString));
        assertEquals(expected, SortStringList.top5Tags(listEmpty));
    }
}