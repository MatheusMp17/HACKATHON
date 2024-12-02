import java.util.ArrayList;

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
    
    public static TipoDoacao testeTipoDoacao(String nomeRecebido){
        TipoDoacao tipoDoacao;
        ArrayList<TipoDoacao> tiposDeDoacao = new ArrayList<TipoDoacao>();
            tiposDeDoacao.add(TipoDoacao.itensDeHigiene);
            tiposDeDoacao.add(TipoDoacao.Alimentos);
            tiposDeDoacao.add(TipoDoacao.Roupas);
            tiposDeDoacao.add(TipoDoacao.conforto);
            tiposDeDoacao.add(TipoDoacao.dinheiro);
            tiposDeDoacao.add(TipoDoacao.moveis);
            tiposDeDoacao.add(TipoDoacao.voluntariado);

            for (TipoDoacao tipo: tiposDeDoacao) {
                if(tipo.getNome().equals(nomeRecebido)){
                    tipoDoacao = tipo;
                    return tipoDoacao;
                }
            }
        
        return null;
    }

}