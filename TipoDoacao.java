enum TipoDoacao{
    itensDeHigiene("itens de higiene"),
    Alimentos("alimentos"),
    Roupas("roupas"),
    conforto("conforto"),
    moveis("móveis"),
    voluntariado("Serviço voluntário"),
    dinheiro("dinheiro");

    private final String nome;
    TipoDoacao(String nome) {
        this.nome = nome;
    }
    

}