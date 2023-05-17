public class Compratore extends Thread{
    private Botteghino b;
    private boolean acquistato;

    public Compratore(String nome, Botteghino b){
        super(nome);
        this.b = b;
        this.acquistato = false;
    }

    @Override
    public void run(){
        String nome = Thread.currentThread().getName();
        //compratore tenta di acquistare un biglietto
        System.out.println(nome + " tenta di acquistare un biglietto");
        if(b.acquistaBiglietto()){
            acquistato = true;
        }
        else{
            acquistato = false;
        }
    }

    public Botteghino getBotteghino(){
        return b;
    }

    public boolean isNotSell(){
        return false;
    }

    public boolean getAcquistato(){
        return acquistato;
    }
}