import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
    

ArrayList<Item> Doadores = new ArrayList<>();  
ArrayList<Item> Receptores = new ArrayList<>();  

try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
    String linha;

    while ((linha = reader.readLine()) != null) {
        String doacao = reader.readLine();

        if (Boolean.valueOf(doacao)) {
            Doadores.add(new Item());  

            for (Item doador : Doadores) {
                String id = reader.readLine();
                String nome = reader.readLine();
                String tipo = reader.readLine();
                String qtd = reader.readLine();

                doador.setId(Integer.valueOf(id));
                doador.setNome(nome);
                doador.setTipo(TipoDoacao.valueOf(tipo));
                doador.setQtd(Integer.valueOf(qtd));
            }
        }

        if (!Boolean.valueOf(doacao)) {
            Receptores.add(new Item()); 

            for (Item receptor : Receptores) {
                String id = reader.readLine();
                String nome = reader.readLine();
                String tipo = reader.readLine();
                String qtd = reader.readLine();

                receptor.setId(Integer.valueOf(id));
                receptor.setNome(nome);
                receptor.setTipo(TipoDoacao.valueOf(tipo));  
                receptor.setQtd(Integer.valueOf(qtd));
            }
        }
    }
} catch (IOException e) {
    System.err.println("Erro ao ler o arquivo: " + e.getMessage());
    return null;  
}


    
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
*\
    //fazer array para doação = falso e um array para doação = true// 
