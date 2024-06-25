package oo.jogodavelha.models;
import java.util.ArrayList;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;

public class Jogo {
    private int n=3;
    private Character jogador;

    ArrayList<ArrayList<Character>> tabuleiro = new ArrayList<>(n);
		
	public ArrayList<ArrayList<Character>> getBoard(){
		return tabuleiro;
	}

    public  ArrayList<ArrayList<Character>> init(){
        return tabuleiro;
    }

    public boolean check(Jogada umaJogada){
        return true;
    }

public ArrayList<ArrayList<Character>> inicializa(){
        for (int i = 0; i < n; i++){
            ArrayList<Character> linha = new ArrayList<>(n);
            for (int j = 0; j < n; j++){
                linha.add(' ');
            }
            tabuleiro.add(linha);
        }
    return tabuleiro;
}

public boolean tenteJogarNaPosicao(int x, int y)throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {
    if (x < 0 || x >= n || y < 0 || y >= n){
            throw new ExcecaoPorCoordenadaInvalida();
        }

        if (tabuleiro.get(x).get(y) != ' ' && jogador != tabuleiro.get(x).get(y)){
            throw new ExcecaoPorCoordenadaInvalida();
        }

        if (jogador != 'X' && jogador != 'O'){
            throw new ExcecaoPorSimboloInvalido();
        }
    return true;
}

public void tenteJogarUmaSegundaVezNaMesmaPosicao(int x, int y, Character jogador, Character jogador2)throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido{
    ArrayList<ArrayList<Character>> tab;
    tab = inicializa();
    if (tab.get(x).get(y) != ' ') {
        throw new ExcecaoPorCoordenadaInvalida();
    }
}

public void tenteJogarUmaSegundaVezEmPosicaoDiferente(int x1, int y1, int x2, int y2, Character jogador)throws ExcecaoPorSimboloInvalido{
    if (jogador != jogadorAtual) {
        throw new ExcecaoPorSimboloInvalido();
    }
}


private Character jogadorAtual = 'O';
public void add(Jogada jogada) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido{
        Coordenada coordenada = jogada.getCoordenada();
        int x = coordenada.getX();
        int y = coordenada.getY();
        ArrayList<ArrayList<Character>> tab;
        tab = inicializa();

        Character jogador = jogada.getJogador();

        if (x < 0 || x >= n || y < 0 || y >= n){
            throw new ExcecaoPorCoordenadaInvalida();
        }

        if (tab.get(x).get(y) != ' '){
            throw new ExcecaoPorCoordenadaInvalida();
        }

        if (jogador != 'X' && jogador != 'O'){
            throw new ExcecaoPorSimboloInvalido();
        }

        if (jogador != jogadorAtual){
            throw new ExcecaoPorSimboloInvalido();
        }

        tab.get(x).set(y, jogador);
        jogadorAtual = (jogador == 'X') ? 'O' : 'X';
}

private boolean tentativaDeVitoriaNaHorizontal(int linha, Character jogador){
    Character vencedor = null;
    ArrayList<ArrayList<Character>> tab;
    tab = inicializa();

    for (ArrayList<Character> linha2 : tab){
        int contadorX = 0;
        int contadorO = 0;
        
        for (Character elemento : linha2){
            if (elemento == 'X') {
                contadorX++; 
            } else if (elemento == 'O'){
                contadorO++;
            } else {
                contadorX = 0; 
                contadorO = 0;
            }

            if (contadorX == 3 || contadorO == 3){
                vencedor = jogador;
                return true;
            }
        }
    }
    return false;
}

private boolean tentativaDeVitoriaNaVertical(int coluna, Character jogador){
    Character vencedor = null;
    ArrayList<ArrayList<Character>> tab;
    tab = inicializa();

    for (coluna = 0; coluna < tabuleiro.get(0).size(); coluna++){
        int contadorX = 0;
        int contadorO = 0;
        for (ArrayList<Character> coluna2 : tab){
            Character elemento = coluna2.get(coluna);
            if (elemento == 'X'){
                contadorX++;
            } else if (elemento == 'O'){
                contadorO++;
            } else {
                contadorX = 0; 
                contadorO = 0;
            }
            
            if (contadorX == 3 || contadorO == 3){
                vencedor = jogador;
                return true;
            }
        }
    }
    return false;
}

public boolean tentativaDeVitoriaDiagonal1(){
    ArrayList<ArrayList<Character>> tab;
    tab = inicializa();
    if(tab.get(0).get(0) == 'X' && tab.get(1).get(1) == 'X' && tab.get(2).get(2) == 'X'){
        return true;
    }else if(tab.get(0).get(0) == 'O' && tab.get(1).get(1) == 'O' && tab.get(2).get(2) == 'O'){
        return true;
    }
    return false;
}

public boolean tentativaDeVitoriaDiagonal2(){
    if(tabuleiro.get(0).get(2) == 'X' && tabuleiro.get(1).get(1) == 'X' && tabuleiro.get(2).get(0) == 'X'){
        return true;
    }else if(tabuleiro.get(0).get(2) == 'O' && tabuleiro.get(1).get(1) == 'O' && tabuleiro.get(2).get(0) == 'O'){
        return true;
    }
    return false;
}
    
    
int linha;
int coluna;
public boolean hasWinner(){
    if(tentativaDeVitoriaNaHorizontal(linha, jogador))
        return true;
    if(tentativaDeVitoriaNaVertical(coluna,jogador))
        return true;
    if(tentativaDeVitoriaDiagonal1()){
        return true;
    }
    if(tentativaDeVitoriaDiagonal2()){
        return true;
    }
    return false;
}

public boolean empate(){
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (tabuleiro.get(i).get(j) == ' '){
                return false; 
            }
        }
    }
    if (hasWinner() == false){
        return true; 
    }

    return false; 
}


public void imprimir(){
    System.out.println("  0 1 2");
    for (int i = 0; i < 3; i++){
        System.out.print(i + " ");
        for (int j = 0; j < 3; j++){
            System.out.print(tabuleiro.get(i).get(j));
            if (j < 2){
                System.out.print("|");
            }
        }
        System.out.println();
            if (i < 2){
                System.out.println("  -----");
            }
    }
}

}

