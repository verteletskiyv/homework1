package part3;

import part3.figures.AbstractFigure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FigureSortingOperation {
    public static Collection<AbstractFigure> sortByVolume(Collection<AbstractFigure> figures) {
        if (figures == null) return new ArrayList<>();

        return figures.stream()
                .sorted(Comparator.comparingDouble(AbstractFigure::calculateVolume))
                .collect(Collectors.toList());
    }
}
