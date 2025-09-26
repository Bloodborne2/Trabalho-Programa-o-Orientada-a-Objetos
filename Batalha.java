public class Batalha {

    private final Criatura jogador;
    private final Criatura inimigo;
    private String vencedor;

    public Batalha(Criatura jogador, Criatura inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.vencedor = "Em andamento";
    }

    public void iniciar() {
        System.out.println("\n=== A BATALHA COMEÇA: " + jogador.getNome() + " vs " + inimigo.getNome() + " ===");
        jogador.fraseDeApresentacao();
        inimigo.fraseDeApresentacao();

        while (true) { 
            
            System.out.println("\nVez do Jogador: ");
            jogador.fazAtaque(inimigo);

            if (inimigo.estaVivo()) {
                System.out.println("Vez do Inimigo: ");
                inimigo.fazAtaque(jogador);
            }

            if (!jogador.estaVivo()) {
                jogador.fraseDeMorte();
                System.out.println(inimigo.getNome() + " Venceu!");
                this.vencedor = inimigo.getNome();
                break;
            } else if (!inimigo.estaVivo()) {
                inimigo.fraseDeMorte();
                System.out.println(jogador.getNome() + " Venceu!");
                this.vencedor = jogador.getNome();
                break;
            } else {
                jogador.mostraVida();
                inimigo.mostraVida();
            }
        }
        System.out.println("=== BATALHA ENCERRADA ===");
    }

    public String getVencedor() {
        return vencedor;
    }

    public Criatura getInimigo() {
        return inimigo;
    }

     public Criatura getJogador() {
        return jogador;
    }
}