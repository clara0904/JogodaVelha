package oo.jogodavelha.exceptions;

import java.util.ArrayList;

import oo.jogodavelha.models.Coordenada;

public class ExcecaoPorCoordenadaInvalida extends Exception{
    public ExcecaoPorCoordenadaInvalida(){
        super("Coordenada inválida.");
    }    

	public static void testJogadaEmZonaPreenchida(Coordenada coordenada, ArrayList<ArrayList<Character>> tab) throws  ExcecaoPorCoordenadaInvalida{ 
		int x = coordenada.getX();
		int y = coordenada.getY();

			if(tab.get(x).get(y) != ' ' || tab.get(x).get(y) == 'O' && tab.get(x).get(y) == 'X'){
				throw new ExcecaoPorCoordenadaInvalida();
			}
		}

	public static void posicaoInexistente(Coordenada coordenada) throws  ExcecaoPorCoordenadaInvalida{
		int x = coordenada.getX();
		int y = coordenada.getY();
		if(x<0 || x>=3 || y<0 || y>=3){
			throw new ExcecaoPorCoordenadaInvalida();
		}
	}

}
