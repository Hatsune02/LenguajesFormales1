import backend.Analizer;

public class Main {
    public static void main(String[] args) {
        String xd = "gatos perros chuchos pepo 8956 9.96 * = == *= >=";
        Analizer analizer = new Analizer();
        analizer.analize(xd);

    }
}