import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Botteghino b = new Botteghino();
        List <Compratore> compratori = new ArrayList<>();

        for(int i = 0; i < 30; i++){
            compratori.add( new Compratore("Compratore " + (i+1), b));
        }

        for (Compratore comp : compratori) {
            comp.start();
        }

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex) {}

        int numCasuale = (int) (Math.random() * 5 + 1);
        if(!compratori.get(numCasuale).getBotteghino().restituisciBiglietto()){
            System.out.println(compratori.get(numCasuale).getName() + " ha riconsegnato il biglietto");
        }

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex) {}

        for(Compratore comp: compratori){
            if(!comp.getAcquistato()){
                System.out.println(comp.getName() + " arrestato");
                comp.interrupt();
            }
        }

        System.exit(0);
    }
}
