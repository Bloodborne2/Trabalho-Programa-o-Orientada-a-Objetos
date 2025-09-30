import java.util.Random;

public class Hades extends Inimigo {

    public Hades() {
        super("Hades, o imortal", 600, 70, new Bloqueio(30) ); 
    }

    @Override
    public void fazAtaque( Criatura criaturaAtacada ){
        Random rd = new Random();
        // 20% de chance de ficar parado e não atacar
        if (rd.nextInt(0,100) < 20) {
            System.out.println(this.getNome() + " ficou confuso e não atacou.");
            return;
        }
        
        // Se atacar, sorteia o dano entre 50 e 100
        int danoSorteado = rd.nextInt(50, 101); 
        System.out.println( this.getNome() + " faz ataque com dano sorteado: " + danoSorteado + "!");
        criaturaAtacada.tomaDano(danoSorteado);
    }

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Grrrrr... O Hades vai esmagaaar você!");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("Hades... esm...agado...");
    }
    
}