package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsumoAutomobile {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumoAutomobile.class);

    public static double calcolaKmLitro(int numeroKm, int litriConsumati) {
        double kmPerLitro = numeroKm / litriConsumati;
        System.out.println("La tua auto fa " + kmPerLitro + " km/l");
        return kmPerLitro;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Quanti km hai fatto?");
            int km = scanner.nextInt();
            System.out.println("Quanti litri hai fatto secchi?");
            int litri = scanner.nextInt();
            calcolaKmLitro(km, litri);
        } catch (ArithmeticException e) {
            LOGGER.error("Non è possibile che hai consumato 0 litri"); //uso logger al posto di system.out.println
        } catch (InputMismatchException e) {
            LOGGER.error("Inserire dei numeri");
        }

    }
}
