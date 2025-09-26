public class ArcoEFlecha extends Arma {

    private int municao;

    public ArcoEFlecha(){
        super("Arco e Flecha", 250, 85 );
        this.municao = 10; // Munição inicial
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
            return 0; 
        }
    }
    
}