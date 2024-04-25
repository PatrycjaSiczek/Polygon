 public class ShapeDecorator implements Shape {
        protected Shape decoratedShape;

        public ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }

        @Override
        public String toSvg(String parameters) {
            return decoratedShape.toSvg(parameters);
        }
    }

//Zdefiniuj klasę ShapeDecorator implementującą interfejs Shape, która posiadać będzie chronione pole Shape decoratedShape.
//Pole to powinno być ustawiane w konstruktorze. Nadpisz metodę toSvg w taki sposób, by zawierała wywołanie tej samej metody
//na rzecz obiektu decoratedShape. Po klasie ShapeDecorator podziedzicz nową klasę SolidFillShapeDecorator.
//Klasa ta powinna posiadać prywatne pole String color. W konstruktorze ma przyjmować obiekt klasy Shape oraz kolor wypełnienia typu String.
//W jej metodzie toSvg wywołaj metodę toSvg na rzecz decoratedShape, z parametrami jak w zadaniu 1.
//Utwórz dwa obiekty klasy SolidFillShapeDecorator tak, aby parametrem jednego był obiekt wielokąta, a drugiego elipsy.
