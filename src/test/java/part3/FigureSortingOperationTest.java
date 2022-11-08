package part3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import part3.figures.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FigureSortingOperationTest {
    public static List<AbstractFigure> list1, list2, list3;
    public static Set<AbstractFigure> set1, set2, set3;

    @BeforeClass
    public static void initCollections() {
        list1 = List.of(new Cube(25), new Cylinder(20, 20), new Sphere(15));
        list2 = Stream.of(new Cylinder(0.1, 11.1), null, new Sphere(2.2)).toList();
        list3 = new ArrayList<>();

        set1 = Set.of(new Cube(25), new Cylinder(20, 20), new Sphere(15));
        set2 = Stream.of(new Cylinder(0.1, 11.1), null, new Sphere(2.2)).collect(Collectors.toSet());
        set3 = new HashSet<>();
    }

    @Test
    public void sortByVolumeShouldNotReturnNullHavingNonNullInput() {
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(list1));
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(list2));
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(list3));
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(set1));
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(set2));
        Assert.assertNotNull(FigureSortingOperation.sortByVolume(set3));
    }

    @Test
    public void sortByVolumeShouldReturnAListOfFiguresSortedByVolumeASC() {
        List<AbstractFigure> expected = new ArrayList<>();
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(list3));
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(set3));

        expected.add(new Sphere(15));
        expected.add(new Cube(25));
        expected.add(new Cylinder(20, 20));
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(list1));
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(set1));
        expected.clear();

        expected.add(new Cylinder(0.1, 11.1));
        expected.add(new Sphere(2.2));
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(list2));
        Assert.assertEquals(expected, FigureSortingOperation.sortByVolume(set2));
    }

    @Test
    public void volumeGettersOfFiguresShouldReturnCorrectValues() {
        Assert.assertEquals(15625, Math.floor(new Cube(25).getVolume()), 1e-9);
        Assert.assertEquals(25132, Math.floor(new Cylinder(20, 20).getVolume()), 1e-9);
        Assert.assertEquals(14137, Math.floor(new Sphere(15).getVolume()), 1e-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingFigureWithZeroOrNegativeValuesShouldThrowIllegalArgumentException() {
        FigureSortingOperation.sortByVolume(List.of(new Sphere(0)));
        FigureSortingOperation.sortByVolume(List.of(new Sphere(-1)));
        FigureSortingOperation.sortByVolume(List.of(new Cube(0)));
        FigureSortingOperation.sortByVolume(List.of(new Cube(-1)));
        FigureSortingOperation.sortByVolume(List.of(new Cylinder(0, 1)));
        FigureSortingOperation.sortByVolume(List.of(new Cylinder(1, 0)));
        FigureSortingOperation.sortByVolume(List.of(new Cylinder(1, -1)));
        FigureSortingOperation.sortByVolume(List.of(new Cylinder(-1, 1)));
        FigureSortingOperation.sortByVolume(List.of(new Cylinder(-1, 1)));
    }

    @Test(expected = NullPointerException.class)
    public void sortByVolumeShouldThrowNPEifInputIsNull() {
        Assert.assertNull(FigureSortingOperation.sortByVolume(null));
    }
}