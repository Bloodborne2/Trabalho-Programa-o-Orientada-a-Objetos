public abstract class Inimigo extends Criatura {

    int ataque;
    Defesa defesa;

    public Inimigo(String nome, int vida, int ataque,
           Defesa defesa) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public void fazAtaque( Criatura criaturaAtacada ){
        System.out.println( "Inimigo faz ataque!");
        criaturaAtacada.tomaDano(ataque);
    }

    @Override
    public void tomaDano( int dano ){
        int danoReduzido = this.defesa.getDanoReduzido(dano);
        super.tomaDano( danoReduzido );
    }

}