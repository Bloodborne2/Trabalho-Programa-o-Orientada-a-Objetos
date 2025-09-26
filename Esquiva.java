import java.util.Random;

public class Esquiva extends Defesa {
    private int chance;

    Esquiva( int chance ){
        this.chance = chance;
    }

    @Override
    public int getDanoReduzido( int dano ){
        Random rd = new Random();
        int sorteio = rd.nextInt(0,100);
        if( sorteio < this.chance ){
            //--esquiva bem sucedida;
            System.out.println("Esquivou!!!!!!");
            return 0;
        }
        //--Esquiva falhou
        return dano;
    }
}
