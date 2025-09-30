import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private static final int VIDA_ICaNICIAL_JOGADOR = 1000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("### BEM-VINDO AO JOGO ###");
        System.out.print("Escolha seu nome: ");
        String nomeJogador = sc.nextLine();

        System.out.println("\nEscolha uma arma de CURTA DISTÂNCIA:");
        Arma armaCurta = escolherArma(sc, new Arma[]{ new Faca(), new Espada() });

        System.out.println("\nEscolha uma arma de LONGA DISTÂNCIA:");
        Arma armaLonga = escolherArma(sc, new Arma[]{ new ArcoEFlecha(), new Pistola() });

        Criatura jogador = new Jogador(
            nomeJogador, 
            new Arma[]{ armaCurta, armaLonga }
        );

        List<Criatura> inimigos = Arrays.asList(
            new EvilForsen(), 
            new Hades(),     
            new Zote()    
        );

        List<Batalha> historicoBatalhas = new ArrayList<>();
        boolean jogadorVenceuTudo = true;

        for (int i = 0; i < inimigos.size(); i++) {
            Criatura inimigoAtual = inimigos.get(i);
            
            // Restaura a vida do jogador antes de cada nova batalha (se não for a primeira)
            if (i > 0) {
                jogador.restauraVida();
            }

            Batalha batalha = new Batalha(jogador, inimigoAtual);
            historicoBatalhas.add(batalha);
            batalha.iniciar();

            if (batalha.getVencedor().equals(jogador.getNome())) {
                System.out.println("\nVocê VENCEU " + inimigoAtual.getNome() + " e avança para a próxima fase!");
            } else {
                System.out.println("\nVocê foi derrotado por " + inimigoAtual.getNome() + ". O jogo acabou.");
                jogadorVenceuTudo = false;
                break;
            }
        }

        // --- RESULTADO FINAL ---
        System.out.println("\n###############################");
        System.out.println("### RESUMO DA SESSÃO DE JOGO ###");
        System.out.println("###############################");
        
        if (jogadorVenceuTudo) {
            System.out.println("PARABÉNS! Você VENCEU todas as 3 batalhas!");
        } else {
            System.out.println("Fim de Jogo.");
        }

        for (int i = 0; i < historicoBatalhas.size(); i++) {
            Batalha b = historicoBatalhas.get(i);
            System.out.printf("Batalha %d (%s vs %s): Vencedor: %s\n", 
            (i + 1), b.getJogador().getNome(), b.getInimigo().getNome(), b.getVencedor());
        }
        
        sc.close();
    }

    private static Arma escolherArma(Scanner sc, Arma[] opcoes) {
        int n = 1;
        for (Arma arma : opcoes) {
            System.out.print(n + ") ");
            arma.mensagem();
            n++;
        }

        int escolha;
        while (true) {
            System.out.print("Digite o número da arma: ");
            try {
                escolha = sc.nextInt();
                if (escolha >= 1 && escolha < n) {
                    break;
                } else {
                    System.out.println("Número inválido.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.next(); 
            }
        }
        return opcoes[escolha - 1];
    }
}