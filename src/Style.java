import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        if(fillColor == null){
            this.fillColor = "transparent";
        } else {
             this.fillColor = fillColor;}
        if(strokeColor == null) {
            this.strokeColor = "black";
        } else {
            this.strokeColor = strokeColor;}
        if(strokeWidth == null) {
            this.strokeWidth = 1.0;
        } else{
            this.strokeWidth = strokeWidth;}
    }

    // Napisz publiczną metodę toSvg() zwracającą napis, będący opcją style, którą można umieścić np. w tagu <polygon>.
    public String toSvg(){
        return String.format(Locale.ENGLISH, "" + "style=\"stroke:%s;stroke-width:%f;fill:%s\"", strokeColor, strokeWidth, fillColor);
    }
}

//Zadanie 1.
//Zdefiniuj klasę Style o finalnych, publicznych polach klasy String: fillColor, strokeColor oraz Double: strokeWidth. Napisz trójargumentowy konstruktor ustawiający te wartości.
//Napisz publiczną metodę toSvg() zwracającą napis, będący opcją style, którą można umieścić np. w tagu <polygon>.
//Dopuść możliwość pominięcia stylu przy konstrukcji. Wówczas należy narysować przezroczysty (fillColor) wielokąt, z czarnym obrysem (strokeColor) o grubości jednego piksela (strokeWidth).