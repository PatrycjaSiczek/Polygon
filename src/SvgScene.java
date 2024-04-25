import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SvgScene {
    //Napisz klasę SvgScene posiadającą prywatną listę obiektów Polygon.
    private List<Polygon> polygons;
    //lub
    //  private Polygon[] polygons = new Polygon[0];
    public void addPolygon(Polygon polygon){
        polygons.add(polygon);}
    //lub
    //public void addPolygon(Polygon polygon) {
    //    polygons = Arrays.copyOf(polygons, polygons.length + 1);
    //    polygons[polygons.length - 1] = polygon;}

    public void save(String path){
                String image = "<svg height=\"200\" width=\"300\">";
                for(Polygon polygon : polygons) {
                    image += polygon.toSvg();
                }
                image += "</svg>";

                try {
                    FileWriter fileWriter = new FileWriter(path);
                    fileWriter.write(image);
                    fileWriter.close();
                } catch (IOException e) {
                }
            }

}

//Zadanie 2.
//Napisz klasę SvgScene posiadającą prywatną listę obiektów Polygon. Napisz metodę, która przyjmuje obiekt klasy Polygon oraz dodaje go do listy w obiekcie SvgScene.
//Napisz funkcję save(String), która utworzy plik HTML w ścieżce danej argumentem i zapisze do niego reprezentacje wszystkich wielokątów znajdujących się na kanwie.
