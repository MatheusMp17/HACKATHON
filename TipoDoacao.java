enum TipoDoacao{
    itensDeHigiene("Itens de higiene"),
    Alimentos("Alimentos"),
    Roupas("Roupas"),
    conforto("Conforto"),
    moveis("Móveis"),
    voluntariado("Serviço voluntário"),
    dinheiro("Dinheiro");

    private final String nome;
    TipoDoacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    

}