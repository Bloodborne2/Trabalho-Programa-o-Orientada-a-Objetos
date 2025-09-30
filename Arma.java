import java.util.Random;

public abstract class Arma {
    
    private String nome;
    private int dano;
    private int chance;
    
    public Arma(String nome, int dano, int chance) {
        this.nome = nome;
        this.dano = dano;
        this.chance = chance;
    }

    public void mensagem(){
        System.out.println(
            this.nome + 
            " - dano: " + this.dano +
            " - chance: " + this.chance
        );
    }

    public int getDano(){
        Random rd = new Random();
        int sorteio = rd.nextInt(0,100);
        if( sorteio < this.chance ){
            System.out.println("Ataque atingiu o inimigo");
            return this.dano;
        } else {
           System.out.println("Ataque não atingiu o inimigo.");
           return 0;
        }

    }

    public String getNome() {
        return this.nome;
    }
    

}
