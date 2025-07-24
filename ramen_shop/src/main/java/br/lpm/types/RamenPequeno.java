package br.lpm.types;

import br.lpm.enums.Proteina;
import br.lpm.model.Ramen;

public class RamenPequeno extends Ramen {
    public RamenPequeno(Proteina proteina){
        super(proteina, "Pequeno");
        this.setPrecoBase(9.90);
    }
}