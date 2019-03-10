public class Main
{
    public static void main (String args[])
    {
        Esercizi esercizi = new Esercizi();
        //esercizi.esercizio_2_69();
        //esercizi.esercizio_2_71();
        //esercizi.esercizio_2_73();
        //esercizi.esercizio_2_74(true);
        ///esercizi.esercizio_2_75(true);
        esercizi.esercizio_2_76(true);
        if (esercizi.getScanner() != null)
            esercizi.getScanner().close();
    }
}
