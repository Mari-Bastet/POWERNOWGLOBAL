package fiap.br.powernow.domain;

public enum Categoria {
	
	CAMISETA("Camiseta"),
    CAMISA("Camisa"),
    CALCA("Calça"),
    BERMUDA("Bermuda"),
    CASACO("Casaco"),
    VESTIDO("Vestido"),
    SAIA("Saia"),
    BLUSA("Blusa"),
    SUETER("Suéter"),
    JAQUETA("Jaqueta"),
    COLETE("Colete"),
    ROUPA_INTIMA("Roupa Íntima"),
    ROUPA_ESPORTIVA("Roupa Esportiva"),
    ROUPA_SOCIAL("Roupa Social"),
    ROUPA_PRAIA("Roupa de Praia"),
    PIJAMA("Pijama"),
    ROUPA_BELEZA("Roupa de Beleza"),
    ROUPA_INFANTIL("Roupa Infantil"),
    ROUPA_BEBe("Roupa de Bebê"),
    ROUPA_GRANDE("Roupa Grande"),
    ROUPA_DESFILE("Roupa de Desfile"),
    ROUPA_CASAMENTO("Roupa de Casamento"),
    ROUPA_TRABALHO("Roupa de Trabalho");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
