import java.util.Scanner;

public class Jogador extends Criatura {

    Arma[] armas;

    public Jogador(String nome, Arma[] armas ) {
        super(nome,1000);
        this.armas = armas;
    }

    @Override
    public void fazAtaque(Criatura criaturaAtacada) {
        
        Scanner sc = new Scanner(System.in);

        //--MENSAGEM
        System.out.println("Escolha sua arma: ");
        int n = 1;
        for( Arma arma : armas ){
            System.out.print(n + ") ");
            arma.mensagem();
            n++;
        }

        //--ESCOLHA
        int escolha;
        try {
            escolha = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            sc.next(); // Limpa o buffer de entrada
            escolha = -1; // Força a re-entrada
        }

        while( escolha < 1 || escolha >= n ){
            System.out.println("Número inválido, digite novamente:");
            try {
                escolha = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                sc.next();
                escolha = -1;
            }
        }

        //--APLICA DANO
        Arma armaSelecionada = armas[escolha-1];
        int danoDaArma = armaSelecionada.getDano();
        
        if (danoDaArma == 0 && (armaSelecionada instanceof ArcoEFlecha || armaSelecionada instanceof Pistola)) {
            System.out.println("A arma " + armaSelecionada.getNome() + " está sem munição e não causou dano!");
        } else if (danoDaArma == 0) {
             System.out.println("A arma " + armaSelecionada.getNome() + " falhou!");
        }

        if (danoDaArma > 0) {
            criaturaAtacada.tomaDano( danoDaArma );
        }
        
    }
    

    @Override
    public void fraseDeApresentacao() {
        System.out.println("Eu, " + this.getNome() + ", vim para vencer! Não contava com minha astúcia!");
    }

    @Override
    public void fraseDeMorte() {
        System.out.println("Pipipipipipipipipi");
    }
    
}