public class Botteghino {
    private static int MAX_BIGLIETTI = 15;
    private static int NUM_VENDITORI = 3;
    private static int biglietti_vendibili = 5;
    private int biglietti_venduti;
    private int venditori_occupati;
    private boolean ottenuto;
    private boolean restituito;


    public Botteghino(){
        this.biglietti_venduti = 0;
        this.venditori_occupati = 0;
        this.ottenuto = true;
        this.restituito = false;
    }

    public synchronized boolean acquistaBiglietto(){
        String nome = Thread.currentThread().getName();
        while(venditori_occupati == NUM_VENDITORI || biglietti_venduti == MAX_BIGLIETTI){
            ottenuto = false;
            System.out.println(nome + " non può acquistare un biglietto");
            try{
                wait();
            }catch(InterruptedException ex){}
        }
        if(biglietti_venduti % biglietti_vendibili == 0 && biglietti_venduti != 0){
            System.out.println("Venduti " + biglietti_venduti + " biglietti!");
        }
        venditori_occupati++;
        try{
            long sleepTime = 1000;
            Thread.sleep(sleepTime);
        }catch(InterruptedException ex) {}
        biglietti_venduti++;
        ottenuto = true;
        venditori_occupati--;
        System.out.println(nome + " ha acquistato un biglietto");
        System.out.println("Biglietti venduti: " + biglietti_venduti);
        notifyAll();
        return ottenuto;
    }

    public synchronized boolean restituisciBiglietto(){
        biglietti_venduti--;
        restituito = true;
        return restituito;
    }
}