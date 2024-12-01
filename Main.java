import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Item> doadores = new ArrayList<>();
        ArrayList<Item> receptores = new ArrayList<>();

        Item doacao1 = new Item(1,"Camille",TipoDoacao.Roupas,5,true);
        Item doacao2 = new Item(2,"Matheus",TipoDoacao.Alimentos,15,true);
        Item doacao3 = new Item(3,"Samuel",TipoDoacao.dinheiro,5000,true);
        Item doacao4 = new Item(4,"Bruno",TipoDoacao.voluntariado,24,true);

        doadores.add(doacao1);
        doadores.add(doacao2);
        doadores.add(doacao3);
        doadores.add(doacao4);

        Item recep1 = new Item(1,"Luis",TipoDoacao.Roupas,2,false);
        Item recep2 = new Item(2,"Henrique",TipoDoacao.Alimentos,8,false);
        Item recep3 = new Item(3,"Rodrigo",TipoDoacao.dinheiro,500,false);
        Item recep4 = new Item(4,"Thomas",TipoDoacao.conforto,10,false);


        receptores.add(recep1);
        receptores.add(recep2);
        receptores.add(recep3);
        receptores.add(recep4);     

   
        escritaDeArquivo(doadores, "doadores.txt" );
        escritaDeArquivo(receptores, "receptores.txt" );
    }

    public static void escritaDeArquivo(ArrayList< Item > itens, String nomeArquivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
       
        for (Item item: itens) {
            try {
                
                writer.write(item.toString());
                writer.newLine();
                System.out.println("Itens salvos com sucesso no arquivo ");
                
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }       
          
        }
        writer.close();

   

      /*   try (BufferedReader reader = new BufferedReader(new FileReader("arquivo1.txt"))) {
            String linha;

            do {
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

                    Receptores.add(receptor);
                }
            } while ((linha = reader.readLine()) != null);
            System.out.println(Receptores.get(0));
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        for (Item doacao : Doadores) {
            for (Item d : Receptores) {
                if (doacao.getTipo().equals(d.getTipo()) && doacao.getQtd() == (d.getQtd())) {
                    Doadores.remove(doacao);
                    Receptores.remove(d);
                }
                if (doacao.getTipo().equals(d.getTipo()) && doacao.getQtd() > (d.getQtd())) {
                    Receptores.remove(d);
                    doacao.setQtd((doacao.getQtd()) - d.getQtd());
                }
                if (doacao.getTipo().equals(d.getTipo()) && doacao.getQtd() < (d.getQtd())) {
                    Doadores.remove(doacao);
                    d.setQtd((d.getQtd()) - doacao.getQtd());
                }
            }

        }*/
    }

}

/*
 * A ferramenta tem o objetivo de facilitar a prefeitura no processo de doações
 * e pedidos de ajuda entre doadores, vítimas e instituições.
 * O processo começa com o cadastro da pessoa ou instituições, usando números de
 * identidade (será explicado depois), endereço e doação. A
 * partir daí, a pessoa ou instituição seleciona se é uma vítima ou doador,
 * depois determinar se o número de identidade é para um CPF ou
 * um CNPJ.
 * Após isso, duas listas mantem relação entre sí, a lista de doador e a lista
 * de vítimas. Na lista de doador, a instituição ou pessoa
 * doadora diz os materiais que pode entregar às vítimas, enquanto a lista de
 * vítimas, a pessoa ou instituição diz o que precisa. Desse modo,
 * os doadores e vítimas criam uma "ligação", enquanto os pedidos das vítimas
 * que não formam uma ligação com algum doador, são notificados à
 * prefeitura
 */
