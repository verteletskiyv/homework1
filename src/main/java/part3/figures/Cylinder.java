package figureCollection.figures;

public class Cylinder extends AbstractFigure {
    private double height;
    private double baseRadius;

    public Cylinder(double height, double baseRadius) {
        this.height = height;
        this.baseRadius = baseRadius;
        this.volume = Math.PI * Math.pow(baseRadius, 2) * height;
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
    public double getVolume() {
        return this.volume;
    }
}
