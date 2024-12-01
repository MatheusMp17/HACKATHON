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

    public String getNome() {
        return nome;
    }
    

}