public class PessoaDoador extends Pessoa{
    private Item doacao;
    private PessoaDoador(int id, Endereco enderecoPessoa, String email, Item doacao) {
        super(id, enderecoPessoa, email);
        setDoacao(doacao);
    }
    public void setDoacao(Item doacao){
        this.doacao = doacao;
    }
    public Item getDoacao() {
        return doacao;
    }
}

