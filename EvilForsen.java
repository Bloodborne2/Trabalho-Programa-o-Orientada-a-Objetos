public class EvilForsen extends Inimigo {

    public EvilForsen() {
        super("EvilForsen, o assasino de Chipre", 550, 40, new DefesaHibrida(15, 25) ); 
    }

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Prepare-se para a fim definitivo.");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("If you don't snus... you lose!");
    }
    
}