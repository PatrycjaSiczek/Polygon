    import java.util.Locale;

    public class StrokeShapeDecorator extends ShapeDecorator {
        String color;
        double width;

        public StrokeShapeDecorator(Shape shape, String color, double width) {
            super(shape);
            this.color = color;
            this.width = width;
        }

        public String toSvg(String parameters){
            return decoratedShape.toSvg(String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" %s ", color, width, parameters));
        }
    }

//Zadanie 3.
//Utwórz klasę StrokeShapeDecorator posiadającą prywatne pola String color i double width,
// które powinny być ustawione w konstruktorze. Wywołaj metodę toSvg podobnie jak w zadaniu 2. formatując napis
//"stroke=\"%s\" stroke-width=\"%f\" "
//kolorem i grubością obrysu. Przetestuj udekorowanie tą klasą obiektów będących wynikiem poprzedniego zadania.


