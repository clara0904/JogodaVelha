	package oo.jogodavelha.models;

	public class Jogada{
		private Character jogador;
		private Coordenada coordenada;

		public Jogada(Character jogador, Coordenada coordenada){
			this.jogador = jogador;
			this.coordenada = coordenada;
		}
		
		public Character getJogador(){return jogador;}
		public Coordenada getCoordenada(){return coordenada;}
}
