import backend.Analizer;

public class Main {
    public static void main(String[] args) {
        String xd = "gatos.perros chuchos pepo 8956 9.96 * = == *= >==";
        //String xd = ">= >> perro ";
        Analizer analizer = new Analizer();
        analizer.analize(xd);

    }
}