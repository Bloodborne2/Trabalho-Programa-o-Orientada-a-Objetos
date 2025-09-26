public class Zote extends Inimigo {

    public Zote() {
        super("Zote, o lendario", 500, 40, new DefesaHibrida(15, 25) ); 
    }

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Chegou a sua hora.");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("It's over!");
    }
    
}