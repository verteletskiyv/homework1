package part3.figures;

import java.util.Objects;

public class Sphere implements FigureCalculations {
    private double radius;

    public Sphere(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Values must be positive");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Values must be positive");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere{" + "radius=" + radius + ", volume=" + calculateVolume() + '}';
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}
