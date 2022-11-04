package figureCollection.figures;

public class Cube extends AbstractFigure {
    private double edge;

    public Cube(double edge) {
        this.edge = edge;
        this.volume = Math.pow(edge, 3);
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }


    @Override
    public double getVolume() {
        return this.volume;
    }
}
