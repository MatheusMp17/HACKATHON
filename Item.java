import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
    private boolean doacao;
    private int id;
    private String nome;
    private TipoDoacao tipo;
    private int qtd;
    
    public Item(){}
    public Item(int id, String nome, TipoDoacao tipoDoacao, int qtd, boolean doacao){
        setId(id);
        setNome(nome);
        setQtd(qtd);
        setTipo(tipoDoacao);
        setDoacao(doacao);
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDoacao getTipo() {
        return tipo;
    }
    public void setTipo(TipoDoacao tipo) {
        this.tipo = tipo;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean getDoacao(){
        return this.doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }


    @Override
    public String toString() {
        return (getDoacao() + "\n" + getId() + "\n" + getNome() + "\n" + getTipo() + "\n" + getQtd());
    }
    
    public String nomeExibição(){
        return ("Nome: " + getNome() + " Tipo: " + getTipo() + " Quantidade: " + getQtd());
    }

    public static void escritaDeArquivo(ArrayList< Item > itens) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("dados.txt"));
      
        for (Item item: itens) {
            if(item.doacao){
                try {
                    writer.write("Doador");
                    writer.newLine();
                    writer.write(item.toString());
                    writer.newLine();
                    System.out.println("Itens salvos com sucesso no arquivo ");
                   
                } catch (IOException e) {
                    System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
                }
              

            } else {
                try  {
                    writer.write("Receptor");
                    writer.newLine();
                    writer.write(item.toString());
                    writer.newLine();
                    System.out.println("Itens salvos com sucesso no arquivo ");
                } catch (IOException e) {
                    System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
                }
               
            }


          
          
        }
        writer.close();
    }      

   public static void escritaDeArquivo(String nomeArquivo, ArrayList< Item > itens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Item item: itens) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("Itens salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
   
  
}


