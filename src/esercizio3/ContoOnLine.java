package esercizio3;

public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxPrelievo) {
        super(titolare, saldo);
        this.maxPrelievo = maxPrelievo;
    }


    public void stampaSaldo() {
        System.out.println("Titolare: " + getTitolare() + " - Saldo: " + getSaldo() + " - Num movimenti: " + getnMovimenti()
                + " - Massimo movimenti: " + getMaxMovimenti() + " - Massimo prelievo possibile: " + maxPrelievo);
    }


    public void preleva(double prelievo) {
        try {
            stampaSaldo();
            if (prelievo <= maxPrelievo) {
                super.preleva(prelievo);
            } else {
                throw new BancaException("Hai superato il limite massimo prelevabile!");
            }

        } catch (BancaException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
