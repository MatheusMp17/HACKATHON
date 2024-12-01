import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item item = new Item();

        leitor();
           }
     public static void leitor(){
    Scanner teclado = new Scanner(System.in);
Item receptor;
Item doador;
ArrayList<Item> Doadores = new ArrayList<>();  
ArrayList<Item> Receptores = new ArrayList<>();  

try (BufferedReader reader = new BufferedReader(new FileReader("arquivo1.txt"))) {
    String linha;

   do{
        String doacao = reader.readLine();

        if (Boolean.valueOf(doacao)) {
              

           
                String id = reader.readLine();
                String nome = reader.readLine();
                String tipo = reader.readLine();
                String qtd = reader.readLine();
                doador = new Item();
                doador.setDoacao(Boolean.valueOf(doacao));
                doador.setId(Integer.valueOf(id));
                doador.setNome(nome);
                doador.setTipo(TipoDoacao.valueOf(tipo));
                doador.setQtd(Integer.valueOf(qtd));
                Doadores.add(doador);
        }

        else if (!Boolean.valueOf(doacao)) { 
                String id = reader.readLine();
                String nome = reader.readLine();
                String tipo = reader.readLine();
                String qtd = reader.readLine();
                receptor = new Item();
                receptor.setDoacao(Boolean.valueOf(doacao));
                receptor.setId(Integer.valueOf(id));
                receptor.setNome(nome);
                receptor.setTipo(TipoDoacao.valueOf(tipo));  
                receptor.setQtd(Integer.valueOf(qtd));
        
            Receptores.add(new Item());
        }
    } while ((linha = reader. readLine()) != null);
    System.out.println(Receptores.get(0));
    } catch (IOException e) {
    System.err.println("Erro ao ler o arquivo: " + e.getMessage());  
    }
   }
   /*    A ferramenta tem o objetivo de facilitar a prefeitura no processo de doações e pedidos de ajuda entre doadores, vítimas e instituições. 
O processo começa com o cadastro da pessoa ou instituições, usando números de identidade (será explicado depois), endereço e doação. A 
partir daí, a pessoa ou instituição seleciona se é uma vítima ou doador, depois determinar se o número de identidade é para um CPF ou
um CNPJ. 
 Após isso, duas listas mantem relação entre sí, a lista de doador e a lista de vítimas. Na lista de doador, a instituição ou pessoa 
doadora diz os materiais que pode entregar às vítimas, enquanto a lista de vítimas, a pessoa ou instituição diz o que precisa. Desse modo,
os doadores e vítimas criam uma "ligação", enquanto os pedidos das vítimas que não formam uma ligação com algum doador, são notificados à 
prefeitura
*/
}
