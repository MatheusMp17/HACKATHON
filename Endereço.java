public class Endereço {
        private String bairro;
        private String rua;
        private int numero;

        public Endereço(){
            this.setBairro("");
            this.setRua("");
            this.setNumero(0);
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
        