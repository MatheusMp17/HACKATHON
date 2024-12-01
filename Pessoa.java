public class Pessoa {
    private int id;
    private Endereco enderecoPessoa;
    private String email;

    public Pessoa(int id, Endereco enderecoPessoa, String email) {
        this.id = id;
        this.enderecoPessoa = enderecoPessoa;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setEndereco(Endereco enderecoPessoa){
        this.enderecoPessoa = enderecoPessoa;
    }

    public Endereco getEndereco(){
        return this.enderecoPessoa;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}
