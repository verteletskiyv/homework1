package figureCollection;

import figureCollection.figures.AbstractFigure;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FigureSortingOperation {

    public Collection<? extends AbstractFigure> sortFigures(Collection<? extends AbstractFigure> figures) {
        return figures.stream()
                .sorted(Comparator.comparingDouble(AbstractFigure::getVolume))
                .collect(Collectors.toList());
    }

}
