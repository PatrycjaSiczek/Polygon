import java.util.Locale;
public class SolidFilledPolygon extends Polygon{
    private String color;

    public SolidFilledPolygon(int count, Style style, String color) {
        super(count, style);
        this.color = color;
    }
    @Override
    public String toSvg(String parameters) {
        return super.toSvg(
                String.format(Locale.ENGLISH,
                        "fill=\"%s\" %s ", color, parameters)
        );
    }
}
//Napisz klasę SolidFilledPolygon dziedziczącą po Polygon. Klasa powinna posiadać prywatne pole String color ustawiane, obok tablicy punktów, w konstruktorze.
// Przemodeluj funkcję toSvg w interfejsie Shape tak, aby możliwe było przekazanie jej parametru typu String, który zostanie umieszczony w tagu rysowanego obiektu.
// Wykorzystaj poniższy kod: "<polygon points=\"%s\" %s />"
//W klasie SolidFilledPolygon zdefiniuj metodę toSvg, która nadpisze metodę klasy nadrzędnej. Wewnątrz tej metody wywołaj metodę toSvg klasy nadrzędnej,
// przekazując jej jako parametr napis powstały ze sformatowania: "fill=\"%s\" %s " kolejno kolorem i parametrem napisowym.
