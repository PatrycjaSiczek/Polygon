import java.util.Locale;
public class Ellipse implements Shape{
    private Style style;
    private Vec2 center;
    private double x,y;

    public Ellipse(Style style, Vec2 center, double x, double y) {
        this.style = style;
        this.center = center;
        this.x = x;
        this.y = y;
    }
    public String toSvg(String parameters){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%f\" cy=\"%f\" x=\"%f\" y=\"%f\"\n" +
                " %s />",center.x,center.y,x,y,style.toSvg());
    }
}

//Zadanie 4b.
//Napisz klasę Ellipse dziedziczącą po Shape, posiadającą prywatne pola: środek elipsy (Point), długości promieni i styl.
// W jej implementacji metody toSvg() powinno znaleźć się rysowanie z użyciem tagu <ellipse>.
//Zmodyfikuj klasę SvgScene, aby posiadała tablicę obiektów klasy Shape i korzystając z polimorfizmu zapisz w niej obiekty typu Polygon i Ellipse.
//


