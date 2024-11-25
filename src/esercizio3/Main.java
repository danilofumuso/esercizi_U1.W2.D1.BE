package esercizio3;

public class Main {
    public static void main(String[] args) {

        ContoCorrente contoCorrente = new ContoCorrente("Danilo Fumuso", 1019.5);

        ContoOnLine contoOnLine = new ContoOnLine("Riccardo Santilli", 500000, 1000);

        contoCorrente.preleva(800);

        contoOnLine.preleva(1000);


    }
}
