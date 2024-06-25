package oo.jogodavelha;

import java.util.Scanner;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;
import oo.jogodavelha.models.Coordenada;
import oo.jogodavelha.models.Jogada;
import oo.jogodavelha.models.Jogo;
import oo.jogodavelha.models.Tabuleiro;

public class Main{
    public static void main(String[] args){
        Jogo jogo = new Jogo();
        jogo.inicializa(); 

        boolean inicioJogo = true;
        Character jogadorAtual = 'O'; //primeiro sempre será O
        Jogada jogada;
        Tabuleiro tab = new Tabuleiro();

        while (inicioJogo){
            jogo.imprimir();
            System.out.println("Jogador "+jogadorAtual+". Digite a linha: ");
            Scanner scanner = new Scanner(System.in);
            int linha = scanner.nextInt();
            System.out.println("Jogador "+jogadorAtual+". Digite a coluna: ");
            int coluna = scanner.nextInt();

            try {
                jogada = new Jogada(jogadorAtual,new Coordenada(linha,coluna));
                jogo.add(jogada); 
                tab.adicionarJogada(jogada); //adiciona jogada ao mapa
            } catch (ExcecaoPorCoordenadaInvalida e){
                System.err.println("Erro: Coordenada inválida.");
            } catch (ExcecaoPorSimboloInvalido e){
                System.err.println("Erro: Simbolo inválido.");
            }
            
            if (jogo.hasWinner()){
                jogo.imprimir();
                System.out.println("Jogador "+jogadorAtual+" venceu!");
                inicioJogo = false;
                scanner.close();

                System.out.println("\nMapa das jogadas: ");
                tab.imprimirMapaJogadas();
            } else if(jogo.empate()){
                System.out.println("Empate!");
                inicioJogo = false;
                scanner.close();

                System.out.println("\nMapa das jogadas: ");
                tab.imprimirMapaJogadas();
            }
            else {
                jogadorAtual = (jogadorAtual.equals('X')) ? 'O' : 'X';
            }

        }
    }
}


