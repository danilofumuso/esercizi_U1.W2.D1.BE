package esercizio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayDiNumeri {
    private static int randomNumber;
    private static int[] intArray = new int[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array iniziale");
        for (int i = 0; i < intArray.length; i++) {

            randomNumber = (int) (Math.random() * 10);

            intArray[i] = randomNumber;
            System.out.println(intArray[i]);
        }

        while (true) {
            System.out.println("Inserisci un numero, tra 1 e 10, in posizione 2");
            try {
                int userNumber = scanner.nextInt();
                if (userNumber == 0) {
                    System.out.println("Hai premuto zero");
                    break;
                } else if (userNumber > 0 && userNumber < 11) {
                    intArray[1] = userNumber;
                    for (int i = 0; i < intArray.length; i++) {
                        System.out.println(intArray[i]);
                    }
                } else {
                    throw new NumeroMaggioreDieciException("Numero troppo grande");
                }
            } catch (NumeroMaggioreDieciException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input non valido! Inserisci solo numeri interi tra 1 e 10.");
                scanner.nextLine();
            }
        }

    }
}
