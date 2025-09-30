public class Pistola extends Arma {
    
    private int municao;

    public Pistola(){
        super("Pistola", 200, 100 );
        this.municao = 5;
    }

    @Override
    public void mensagem() {
        super.mensagem();
        System.out.println(" (Munição: " + this.municao + ")");
    }

    @Override
    public int getDano() {
        if (this.municao > 0) {
            this.municao--;
            return super.getDano();
        } else {
            System.out.println("Atenção! A munição da Pistola acabou.");
            return 0; 
        }
    }
}