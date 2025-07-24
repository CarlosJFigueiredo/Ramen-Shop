package br.lpm.factories;

import br.lpm.enums.Proteina;
import br.lpm.model.Ramen;
import br.lpm.types.RamenGrande;
import br.lpm.types.RamenMedio;
import br.lpm.types.RamenPequeno;

public class RamenFactory {
    public static Ramen criarRamen(String tipo, String proteina){
        Proteina proteinaEnum = Proteina.fromString(proteina);
        return switch (tipo.toLowerCase()){
            case "pequeno" -> new RamenPequeno(proteinaEnum);
            case "medio" -> new RamenMedio(proteinaEnum);
            case "grande" -> new RamenGrande(proteinaEnum);
            default -> throw new IllegalArgumentException("Tipo de ramen inválido");
        };
    }
}