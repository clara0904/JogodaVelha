package oo.jogodavelha.exceptions;

public class ExcecaoPorSimboloInvalido extends Exception{
    public ExcecaoPorSimboloInvalido(){
        super("Simbolo inválido.");
    }    

    public static void simboloInvalido(Character jogador) throws  ExcecaoPorSimboloInvalido{
        if (jogador != 'X' && jogador != 'O'){
            throw new ExcecaoPorSimboloInvalido();
        } 
    }

}


