public class Bloqueio extends Defesa {
    private int reducao;

    Bloqueio( int reducao ){
        this.reducao = reducao;
    }

    @Override
    public int getDanoReduzido( int dano ){
        System.out.println("Dano amorteceu o valor de " + this.reducao);
        if( this.reducao > dano ){
            return 0;
        }
        return dano - this.reducao;
    }
}
