package part3;

import part3.figures.FigureCalculations;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class FigureSortingOperation {
    /**
     * @param figures collection of objects implementing FigureCalculations (Cube/Cylinder/Sphere/etc.);
     * @return immutable list of objects that implement FigureCalculations sorted by their volume in ascending order;
     * @throws NullPointerException if input is NULL;
     */
    public static Collection<FigureCalculations> sortByVolume(Collection<FigureCalculations> figures) {
        return figures.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(FigureCalculations::calculateVolume))
                .collect(Collectors.toList());
    }
}
