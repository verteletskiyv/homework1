package part2;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortStringListTest {
    private static List<String> listRandom1, listRandom2, listEmptyString, listEmpty;
    private static String strNormal, strDashes, strSymbols, strEmpty;

    @BeforeAll
    public static void setUpInputs() {
        strNormal = "list set map list set map #list #set #map";
        strDashes = "bla-#bla-bla-bla-#bla"; //not separate words. Shouldn't change.
        strSymbols = "     ] }{ {] }[{] ^^&2 &192@ @#@ *** @  "; //not words at all. Should only get trimmed.
        strEmpty = "";

        listRandom1 = List.of("You should try these good #Hashtag in your Instagram or #Tiktok post to get #popular and boost your view",
                "Check out Jane Doe's new #Instagram!",
                "bla-#bla-bla-bla-#bla #java",
                "#java #Instagram Hashtag",
                "#java #research #uxdesigning #js #HTML #uxlife #LoremIpsum #womeninux #react #uxdesignmastery",
                "#js #uixsupply #uxdesign #mobileappdesign #react #userinterface #dribbble #uiux #java #js",
                "#LoremIpsum dolor #js sit amet, c#onsectetur");
        listRandom2 = List.of("#LoremIpsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.",
                "Многие #java программы электронной #JS вёрстки и редакторы #HTML используют #LoremIpsum в качестве текста по умолчанию",
                "Best Popular #Hashtag to use with #LoremIpsum are #graphicarts #HTML #JS",
                "#java #java #JS #LoremIpsum #JS #react #graphicdesignThe #posterdesign #poster #graphicdesign",
                "bla-#bla-bla-bla-#bla", "234567 987654 #%6789 @*&#^ 67891 !&@#*!");
        listEmptyString = List.of("");
        listEmpty = new ArrayList<>();
    }

    @Test
    public void top5ShouldNotReturnNullHavingNonNullInput() {
        assertNotNull(SortStringList.top5Tags(listRandom1));
        assertNotNull(SortStringList.top5Tags(listRandom2));
        assertNotNull(SortStringList.top5Tags(listEmptyString));
        assertNotNull(SortStringList.top5Tags(listEmpty));
    }

    @Test
    public void getUniqueWordsShouldNotReturnNull() {
        assertNotNull(SortStringList.getUniqueWords(strNormal));
        assertNotNull(SortStringList.getUniqueWords(strDashes));
        assertNotNull(SortStringList.getUniqueWords(strSymbols));
        assertNotNull(SortStringList.getUniqueWords(strEmpty));
        assertNotNull(SortStringList.getUniqueWords(null));
    }

    @Test
    public void top5ShouldReturnAMapWith5MostCommonHashTagsOfAGivenListOfStrings() {
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#java", 4L);
        expected.put("#js", 3L);
        expected.put("#LoremIpsum", 2L);
        expected.put("#react", 2L);
        expected.put("#HTML", 1L);
        assertEquals(expected, SortStringList.top5Tags(listRandom1));
        expected.clear();

        expected.put("#LoremIpsum", 4L);
        expected.put("#JS", 3L);
        expected.put("#HTML", 2L);
        expected.put("#java", 2L);
        expected.put("#react", 1L);
        assertEquals(expected, SortStringList.top5Tags(listRandom2));

        expected = new HashMap<>();
        assertEquals(expected, SortStringList.top5Tags(listEmptyString));
        assertEquals(expected, SortStringList.top5Tags(listEmpty));
    }

    @Test
    public void getUniqueWordsShouldReturnACopyOfAGivenStringWithNoDuplicateWords() {
        String expected = "list set map #list #set #map";
        assertEquals(expected, SortStringList.getUniqueWords(strNormal));

        expected = "bla-#bla-bla-bla-#bla";
        assertEquals(expected, SortStringList.getUniqueWords(strDashes));

        expected = "] }{ {] }[{] ^^&2 &192@ @#@ *** @";
        assertEquals(expected, SortStringList.getUniqueWords(strSymbols));

        expected = "";
        assertEquals(expected, SortStringList.getUniqueWords(strEmpty));
        assertEquals(expected, SortStringList.getUniqueWords(null));
    }

    @Test()
    public void top5ShouldThrowNPEifInputIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> SortStringList.top5Tags(null));
        assertTrue(exception.getMessage().contains("\"inputList\" is null"));
    }
}