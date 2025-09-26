public class Malignus extends Inimigo {

    public Malignus() {
        super("Malignus", 1000, 50, new Bloqueio(10) );
    }

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Eu vou te mataaaaarrr!!!!!! MuaMua");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("Nãããããããããããooooooooooo");
    }
    
}