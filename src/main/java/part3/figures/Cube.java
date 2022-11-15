package part3.figures;

import java.util.Objects;

public class Cube implements FigureCalculations {
    private double edge;

    public Cube(double edge) {
        if (edge <= 0)
            throw new IllegalArgumentException("Values must be positive");
        this.edge = edge;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(edge, 3);
    }

    @Override
    public String toString() {
        return "Cube{" + "edge=" + edge + ", volume=" + calculateVolume() + '}';
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.getEdge(), getEdge()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEdge());
    }
}

