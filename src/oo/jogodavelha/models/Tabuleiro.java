package oo.jogodavelha.models;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
    private Map<Coordenada, Character> mapaJogadas;

    public Tabuleiro(){
        mapaJogadas = new HashMap<>();
    }

    public void adicionarJogada(Jogada jogada){
		Coordenada coordenada = jogada.getCoordenada();
		Character jogador = jogada.getJogador();
        mapaJogadas.put(coordenada, jogador);
    }

	public void imprimirMapaJogadas(){
        for (Map.Entry<Coordenada, Character> elemento : mapaJogadas.entrySet()) {
            Coordenada coordenada = elemento.getKey();
            char jogador = elemento.getValue();
            System.out.println("Coordenada ("+coordenada.getX()+", "+coordenada.getY() +"): "+jogador);
        }
    }

}
