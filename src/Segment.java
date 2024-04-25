import java.util.Locale;

public class Segment {
    private final Vec2 p1;
    private final Vec2 p2;

    public Vec2 getP1() {
        return p1;
    }

//    public void setP1(Point p1) {
//        this.p1 = p1;
//    }

    public Vec2 getP2() { //akcesor
        return p2;
    }

    //    public void setP2(Point p2) { //set to mutator
//        this.p2 = p2;
//    }

    public Segment(Vec2 p1, Vec2 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
//    public double distance(Point p1, Point p2){
//        return sqrt(pow(p1.x - p2.x,2)+ pow(p1.y - p2.y,2));
//    }
    public double getDistance(){
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH,"<line x1 = \"%f\" y1= \"%f\" x2 = \"%f\" "+ " y2 =\"%f\" style = \"stroke:red;stroke-width:2\" />", p1.x, p1.y, p2.x, p2.y );
    }


//Napisz funkcję (metodę klasy głównej), która przyjmie: obiekt segment klasy Segment oraz obiekt point klasy Point. Funkcja powinna zwrócić odcinek prostopadły do segment,
// rozpoczynający się w punkcie point o długości równej odcinkowi segment. Następnie zmodyfikuj tę metodę tak,
//aby zwracała tablicę dwóch możliwych do konstrukcji linii oraz przenieś tę metodę jako statyczną do klasy Segment. Szczególne przypadki należy zignorować.
    public static Segment[] perpendicular(Segment line, Vec2 vec2, double r) {
        double a;
        a = (line.p1.y - line.p2.y) / (line.p1.x - line.p2.x);
        double b;
        a=-1/a;
        b= vec2.y-a* vec2.x;

        double x0 = vec2.x;
        double y0 = vec2.y;

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(vec2, new Vec2(x1,y1)), new Segment(vec2, new Vec2(x2,y2))};
    }
}