import java.util.Locale;

public class Polygon implements Shape {
    private Vec2[] arr;
    private Style style;

    public Polygon(int count, Style style) {
        this.style = style;
        arr = new Vec2[count];
    }
    //W klasie Polygon napisz konstruktor kopiujący, wykonujący głęboką kopię obiektu.
//    public Polygon(Polygon polygon) {
//        this.arr = polygon.arr;
//        this.arr = new Point[polygon.arr.length];
//        for (int i = 0; i < polygon.arr.length; i++) {
//            this.arr[i] = new Point(polygon.arr[i].x, polygon.arr[i].y);
//        }
//    }

    public void setPoint(int index, Vec2 vec2) {
        arr[index] = vec2;
    }

    public void setPoints(Vec2[] vec2s){
        arr = vec2s;
    }

    public String toSvg(String parameters) {
        String pointsString = "";
        for(Vec2 vec2 : arr)
            pointsString += vec2.x + "," + vec2.y + " ";

        return String.format(Locale.ENGLISH,"" +
                "<polygon points=\"%s\" %s />", pointsString, parameters);
    }

    static Polygon sqare(Segment line, Style style) {
        double x = (line.getP1().x + line.getP2().x) / 2;
        double y = (line.getP1().y + line.getP2().y) / 2;
        Vec2 center = new Vec2(x, y);
        Segment[] secondLine = Segment.perpendicular(line, center, line.getDistance() / 2);

        Polygon polygon = new Polygon(4, style);
        polygon.setPoint(0, line.getP1());
        polygon.setPoint(1, secondLine[0].getP2());
        polygon.setPoint(2, line.getP2());
        polygon.setPoint(3, secondLine[1].getP2());

        return polygon;
    }

}
//Zmodyfikuj klasę Polygon dodając do jej konstruktora argument Style i modyfikując jej metodę toSvg(), aby uwzględniała styl.
//Napisz publiczną, statyczną metodę wytwórczą klasy Polygon o nazwie square. Funkcja powinna przyjąć jako argumenty
// : obiekt Line, obiekt Style i zwrócić wielokąt będący kwadratem, którego przekątną jest dany odcinek.
//Przeciąż metodę klasy Line zwracającą prostopadły odcinek tak, aby przyjmowała jako dodatkowy argument długość zwracanego odcinka.

