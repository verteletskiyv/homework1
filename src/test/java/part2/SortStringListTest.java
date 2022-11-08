package part2;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SortStringListTest {
    private static List<String> inputList1, inputList2, inputList3, inputList4;
    private static String str1, str2, str3, str4;

    @BeforeClass
    public static void setUpInputs() {
        str1 = "list set map list set map #list #set #map";
        str2 = "bla-#bla-bla-bla-#bla"; //not separate words. Shouldn't change.
        str3 = "     ] }{ {] }[{] ^^&2 &192@ @#@ *** @  "; //not words at all. Should only get trimmed.
        str4 = "";

        inputList1 = List.of("You should try these good #Hashtag in your Instagram or #Tiktok post to get #popular and boost your view",
                "Check out Jane Doe's new #Instagram!",
                "bla-#bla-bla-bla-#bla #java",
                "#java #Instagram Hashtag",
                "#java #research #uxdesigning #js #HTML #uxlife #LoremIpsum #womeninux #react #uxdesignmastery",
                "#js #uixsupply #uxdesign #mobileappdesign #react #userinterface #dribbble #uiux #java #js",
                "#LoremIpsum dolor #js sit amet, c#onsectetur");
        inputList2 = List.of("#LoremIpsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века.",
                "Многие #java программы электронной #JS вёрстки и редакторы #HTML используют #LoremIpsum в качестве текста по умолчанию",
                "Best Popular #Hashtag to use with #LoremIpsum are #graphicarts #HTML #JS",
                "#java #java #JS #LoremIpsum #JS #react #graphicdesignThe #posterdesign #poster #graphicdesign",
                "bla-#bla-bla-bla-#bla", "234567 987654 #%6789 @*&#^ 67891 !&@#*!");
        inputList3 = List.of("");
        inputList4 = new ArrayList<>();
    }

    @Test
    public void top5ShouldNotReturnNullHavingNonNullInput() {
        Assert.assertNotNull(SortStringList.top5Tags(inputList1));
        Assert.assertNotNull(SortStringList.top5Tags(inputList2));
        Assert.assertNotNull(SortStringList.top5Tags(inputList3));
        Assert.assertNotNull(SortStringList.top5Tags(inputList4));
    }

    @Test
    public void getUniqueWordsShouldNotReturnNull() {
        Assert.assertNotNull(SortStringList.getUniqueWords(str1));
        Assert.assertNotNull(SortStringList.getUniqueWords(str2));
        Assert.assertNotNull(SortStringList.getUniqueWords(str3));
        Assert.assertNotNull(SortStringList.getUniqueWords(str4));
        Assert.assertNotNull(SortStringList.getUniqueWords(null));
    }

    @Test
    public void top5ShouldReturnAMapWith5MostCommonHashTagsOfAGivenListOfStrings() {
        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("#java", 4L);
        expected.put("#js", 3L);
        expected.put("#LoremIpsum", 2L);
        expected.put("#react", 2L);
        expected.put("#HTML", 1L);
        Assert.assertEquals(expected, SortStringList.top5Tags(inputList1));
        expected.clear();

        expected.put("#LoremIpsum", 4L);
        expected.put("#JS", 3L);
        expected.put("#HTML", 2L);
        expected.put("#java", 2L);
        expected.put("#react", 1L);
        Assert.assertEquals(expected, SortStringList.top5Tags(inputList2));

        expected = new HashMap<>();
        Assert.assertEquals(expected, SortStringList.top5Tags(inputList3));
        Assert.assertEquals(expected, SortStringList.top5Tags(inputList4));
    }

    @Test
    public void getUniqueWordsShouldReturnACopyOfAGivenStringWithNoDuplicateWords() {
        String expected = "list set map #list #set #map";
        Assert.assertEquals(expected, SortStringList.getUniqueWords(str1));

        expected = "bla-#bla-bla-bla-#bla";
        Assert.assertEquals(expected, SortStringList.getUniqueWords(str2));

        expected = "] }{ {] }[{] ^^&2 &192@ @#@ *** @";
        Assert.assertEquals(expected, SortStringList.getUniqueWords(str3));

        expected = "";
        Assert.assertEquals(expected, SortStringList.getUniqueWords(str4));
        Assert.assertEquals(expected, SortStringList.getUniqueWords(null));
    }

    @Test(expected = NullPointerException.class)
    public void top5ShouldThrowNPEifInputIsNull() {
        Assert.assertNull(SortStringList.top5Tags(null));
    }
}