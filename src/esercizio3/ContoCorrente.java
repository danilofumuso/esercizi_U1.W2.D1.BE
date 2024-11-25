package esercizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public final static Logger LOGGER = LoggerFactory.getLogger(ContoCorrente.class);

    public void preleva(double prelievo) {
        try {
            if ((saldo - prelievo) >= 0) {
                System.out.println("Il tuo saldo è :" + saldo + "€");
                if (nMovimenti < maxMovimenti) {
                    saldo -= prelievo;
                } else {
                    if (saldo - prelievo >= 0.5) {
                        saldo -= (prelievo + 0.5);
                    } else {
                        throw new BancaException("Il conto è in rosso!");
                    }
                }
                System.out.println("Hai prelevato: " + prelievo + "€, adesso il tuo saldo è: " + saldo + "€");
            } else {
                throw new BancaException("Il conto è in rosso!");
            }
        } catch (BancaException e) {
            LOGGER.error(e.getMessage());
            System.out.println("Il tuo saldo è :" + saldo + "€");
        }
        nMovimenti++;
    }

    public String getTitolare() {
        return titolare;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getMaxMovimenti() {
        return maxMovimenti;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }

}
