package rectas;

public record Vector(Punto extremo) {

    private static final double EPSILON = 0.000001;

    public Vector(double x, double y){
        this(new Punto(x, y));
    }

    public Vector(Punto origen, Punto extremo){
        this(extremo.x() - origen.x(), extremo.y() - origen.y());
    }

    public Vector ortogonal(){
        return new Vector(-extremo.y(), extremo().x());
    }

    public boolean sonParalelos(Vector v1, Vector v2){
        return Math.abs(v1.extremo.x()*v2.extremo.y() - v1.extremo.y()*v2.extremo.x()) < EPSILON;
    }

    public Punto extremoDesde(Punto org){
        return new Punto(org.x(), org.y());
    }

    public double modulo(){
        return Math.sqrt(Math.pow(extremo.x(),2) + Math.pow(extremo.y(),2));
    }

    public Vector direccion(){
        double modulo = modulo();
        if(modulo == 0) throw new RuntimeException("El vector es nulo y no tiene direccion");
        return new Vector(extremo.x() / modulo, extremo.y() / modulo);
    }

    public Vector sum(Vector vector){
        return new Vector(extremo.x() + vector.extremo.x(), extremo.y() + vector.extremo.y());
    }

    public Vector dif(Vector vector){
        return new Vector(extremo.x() - vector.extremo.x(), extremo.y() - vector.extremo.y());
    }

    public Vector escalar(Double d){
        return new Vector(extremo.x() * d, extremo.y() * d);
    }
}
