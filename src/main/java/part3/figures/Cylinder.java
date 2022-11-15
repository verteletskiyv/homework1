package part3.figures;

import java.util.Objects;

public class Cylinder implements FigureCalculations {
    private double height;
    private double baseRadius;

    public Cylinder(double height, double baseRadius) {
        if (height <= 0 || baseRadius <= 0)
            throw new IllegalArgumentException("Values must be positive");
        this.height = height;
        this.baseRadius = baseRadius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseRadius() {
        return baseRadius;
    }

    public void setBaseRadius(double baseRadius) {
        this.baseRadius = baseRadius;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "height=" + height + ", baseRadius=" + baseRadius + ", volume=" + calculateVolume() + '}';
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(baseRadius, 2) * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.getHeight(), getHeight()) == 0 && Double.compare(cylinder.getBaseRadius(), getBaseRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getBaseRadius());
    }
}
