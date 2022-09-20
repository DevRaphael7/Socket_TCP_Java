package services;

public class Palavras {

    private String[] palavrasProibidas = { "quente", "frio", "chuvoso" };

    public String verificarPalavra(String palavra) {
        String word = palavra.toLowerCase();

        for(String palavraProibida: palavrasProibidas){
            if(word.contains(palavraProibida)){

                String asteriscos = "";

                for(int ast = 0; ast < palavraProibida.length(); ast++) {
                    asteriscos += "*";
                }

                word = word.replace(palavraProibida, asteriscos);
            }
        }
        
        return word;
    }
    
}
