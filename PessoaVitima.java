public class PessoaVitima extends Pessoa{
    private Item doacao;
    private PessoaVitima(int id, Endereco enderecoPessoa, String email, Item doacao) {
        super(id, enderecoPessoa, email);
        setDoacao(doacao);
    }

    public Item getDoacao() {
        return doacao;
    }
    public void setDoacao(Item doacao) {
        this.doacao = doacao;
    }
}
