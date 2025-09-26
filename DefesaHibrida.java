import java.util.Random;

public class DefesaHibrida extends Defesa {
    private int chanceEsquiva;
    private int reducaoBloqueio;

    DefesaHibrida( int chanceEsquiva, int reducaoBloqueio ){
        this.chanceEsquiva = chanceEsquiva;
        this.reducaoBloqueio = reducaoBloqueio;
    }

    @Override
    public int getDanoReduzido( int dano ){
        Random rd = new Random();
        int sorteio = rd.nextInt(0,100);

        if( sorteio < this.chanceEsquiva ){
            System.out.println("Defesa Híbrida: Esquivou totalmente!");
            return 0;
        }

        System.out.println("Defesa Híbrida: Reduziu o dano em " + this.reducaoBloqueio);
        if( this.reducaoBloqueio > dano ){
            return 0;
        }
        return dano - this.reducaoBloqueio;
    }
}