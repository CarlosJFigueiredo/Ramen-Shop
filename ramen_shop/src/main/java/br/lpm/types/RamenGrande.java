package br.lpm.types;

import br.lpm.enums.Proteina;
import br.lpm.model.Ramen;

public class RamenGrande extends Ramen {
    public RamenGrande(Proteina proteina){
        super(proteina, "Grande");
        this.setPrecoBase(15.90);
    }
}