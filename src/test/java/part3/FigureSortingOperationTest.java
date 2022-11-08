package part3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import part3.figures.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FigureSortingOperationTest {
    public static List<AbstractFigure> listNormal, listWithNull, listEmpty;
    public static Set<AbstractFigure> setNormal, setWithNull, setEmpty;

    @BeforeAll
    public static void initCollections() {
        listNormal = List.of(new Cube(25), new Cylinder(20, 20), new Sphere(15));
        listWithNull = Stream.of(new Cylinder(0.1, 11.1), null, new Sphere(2.2)).toList();
        listEmpty = new ArrayList<>();

        setNormal = Set.of(new Cube(25), new Cylinder(20, 20), new Sphere(15));
        setWithNull = Stream.of(new Cylinder(0.1, 11.1), null, new Sphere(2.2)).collect(Collectors.toSet());
        setEmpty = new HashSet<>();
    }

    @Test
    public void sortByVolumeShouldNotReturnNullHavingNonNullInput() {
        assertNotNull(FigureSortingOperation.sortByVolume(listNormal));
        assertNotNull(FigureSortingOperation.sortByVolume(listWithNull));
        assertNotNull(FigureSortingOperation.sortByVolume(listEmpty));
        assertNotNull(FigureSortingOperation.sortByVolume(setNormal));
        assertNotNull(FigureSortingOperation.sortByVolume(setWithNull));
        assertNotNull(FigureSortingOperation.sortByVolume(setEmpty));
    }

    @Test
    public void sortByVolumeShouldReturnAListOfFiguresSortedByVolumeASC() {
        List<AbstractFigure> expected = new ArrayList<>();
        assertEquals(expected, FigureSortingOperation.sortByVolume(listEmpty));
        assertEquals(expected, FigureSortingOperation.sortByVolume(setEmpty));

        expected.add(new Sphere(15));
        expected.add(new Cube(25));
        expected.add(new Cylinder(20, 20));
        assertEquals(expected, FigureSortingOperation.sortByVolume(listNormal));
        assertEquals(expected, FigureSortingOperation.sortByVolume(setNormal));
        expected.clear();

        expected.add(new Cylinder(0.1, 11.1));
        expected.add(new Sphere(2.2));
        assertEquals(expected, FigureSortingOperation.sortByVolume(listWithNull));
        assertEquals(expected, FigureSortingOperation.sortByVolume(setWithNull));
    }

    @Test
    public void volumeGettersOfFiguresShouldReturnCorrectValues() {
        assertEquals(15625.0, new Cube(25).getVolume(), 0.01);
        assertEquals(25132.74, new Cylinder(20, 20).getVolume(), 0.01);
        assertEquals(14137.16, new Sphere(15).getVolume(), 0.01);
    }

    @Test()
    public void creatingFigureWithZeroOrNegativeValuesShouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Sphere(0))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Sphere(-1))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cube(0))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cube(-1))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cylinder(0, 1))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cylinder(1, 0))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cylinder(1, -1))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");

        exception = assertThrows(IllegalArgumentException.class,
                () -> FigureSortingOperation.sortByVolume(List.of(new Cylinder(-1, 1))),
                "Allowed negative or zero input");
        assertEquals(exception.getMessage(), "Values must be positive");
    }

    @Test()
    public void sortByVolumeShouldThrowNPEifInputIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> FigureSortingOperation.sortByVolume(null));
        assertTrue(exception.getMessage().contains("\"figures\" is null"));
    }
}