import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private boolean translate = false;
    private Vec2 translateVector;

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String parameters) {
        String transform = "";

        if(translate == true) {
            transform += String.format(
                    Locale.ENGLISH,
                    "translate(%f %f) ",
                    translateVector.x,
                    translateVector.y);
        }

        return super.toSvg(
                String.format(Locale.ENGLISH,
                        "transform=\"%s\" %s ", transform, parameters)
        );
    }

    public static class Builder {
        private boolean translate = false;
        private Vec2 translateVector;
        Shape shape;

        public Builder setTranslateVector(Vec2 translateVector) {
            this.translateVector = translateVector;
            this.translate = true;

            return this;
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public TransformationDecorator build() {
            TransformationDecorator tr = new TransformationDecorator(shape);
            tr.translate = translate;
            tr.translateVector = translateVector;
            return tr;
        }
    }
}
//Utwórz klasę TransformationDecorator odpowiadającą za wpisanie w wyświetlany tab informacji o przekształceniach afinicznych: translacji, rotacji i skalowaniu. Na potrzeby każdego z tych działań stwórz prywatne pola:
//  boolean translate, Vec2 translateVector,
//boolean rotate, double rotateAngle, Vec2 rotateCenter, boolean scale, Vec2 scaleVector.
//Wewnątrz klasy TransformationDecorator zdefiniuj publiczną klasę Builder. Zdefiniuj w niej prywatne pola, jednakowe z polami w klasie zewnętrznej oraz pole Shape shape. Wartości logiczne powinny być fałszywe. Napisz po jednej metodzie ustawiającej parametry transformacji i zmieniającej wartość logiczną na prawdziwą na znak, że transformacja ma się wykonać. Funkcje powinny zwracać obiekt klasy Builder z wprowadzonymi zmianami. Napisz w klasie Builder metodę build, która utworzy obiekt TransformationDecorator, przekazując mu jako parametr obiekt shape, a następnie ustawi wszystkim polom w tym obiekcie wartości zapisane w obiekcie Buildera i zwróci tak stworzony obiekt.
//W klasie TransformationDecorator nadpisz metodę toSvg tak, aby poskładać w niej napis definiujący transformację z elementów:
//        "translate(%f %f) ", translateVector.x, translateVector.y "rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y
//"scale(%f %f) ", scaleVector.x, scaleVector.y
//Umieść je w we własności “transform”: "transform=\"%s\" %s", result, parameters.
//Przetestuj tworzenie klasy TransformationDecorator za pomocą całości lub części dostępnych transformacji.
//Uzyskanie możliwości zastosowania filtra oraz wypełnienia obiektu gradientem wymaga zapisania stosownego kodu w tagu <defs>, którego zawartość nie będzie wprost renderowana. Lokalne obiekty w SVG mogą być identyfikowane za pomocą unikalnych nazw (id), a odwoływać można się do nich za pomocą składni “url(#id)”.

