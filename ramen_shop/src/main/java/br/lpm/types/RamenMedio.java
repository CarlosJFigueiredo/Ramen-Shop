package br.lpm.types;

import br.lpm.enums.Proteina;
import br.lpm.model.Ramen;

public class RamenMedio extends Ramen {
    public RamenMedio(Proteina proteina){
        super(proteina, "Medio");
        this.setPrecoBase(12.90);
    }
}