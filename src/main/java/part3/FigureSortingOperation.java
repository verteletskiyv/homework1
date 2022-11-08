package part3;

import part3.figures.AbstractFigure;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class FigureSortingOperation {
    /**
     * @param figures collection of objects extending AbstractFigure (Cube/Cylinder/Sphere/etc.);
     * @return immutable list of AbstractFigures sorted by their volume in ascending order;
     * @throws NullPointerException if input is NULL;
     */
    public static Collection<AbstractFigure> sortByVolume(Collection<AbstractFigure> figures) {
        return figures.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(AbstractFigure::calculateVolume))
                .collect(Collectors.toList());
    }
}