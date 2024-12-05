public class Endereco {
    private String Cidade;
    private String bairro;
    private String rua;
    private int numero;
    public Endereco(String cidade, String bairro, String rua, int numero){
        setCidade(cidade);
        this.setBairro(bairro);
        this.setRua(rua);
        this.setNumero(numero);
    }
    public Endereco(){
        setCidade("");
        this.setBairro("");
        this.setRua("");
        this.setNumero(0);
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }
    public String getCidade() {
        return Cidade;
    }

        public void setBairro(String bairro){
            this.bairro = bairro;
        }
        
        public String getBairro(){
            return this.bairro;
        }

        public void setRua(String rua){
            this.rua = rua;
        }
        
        public String getRua(){
            return this.rua;
        }

        public void setNumero(int numero){
            this.numero = numero;
        }
        
        public int getNumero(){
            return this.numero;
        }

        @Override
    public String toString(){
     return getBairro() + ", " + getRua() + ", " + getNumero() ;
    }

    }
    