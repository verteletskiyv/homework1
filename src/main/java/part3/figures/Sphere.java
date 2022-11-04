package figureCollection.figures;

public class Sphere extends AbstractFigure {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
        this.volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return this.volume;
    }




}
