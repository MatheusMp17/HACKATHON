import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public   class BuscarDoacoes {
    


public static int dosDoadores(Item item){
        int qde = 0;

 Scanner teclado = new Scanner(System.in);
        Item receptor;
        Item doador;
        ArrayList<Item> Doadores = new ArrayList<>();
        ArrayList<Item> Receptores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("arquivo1.txt"))) {
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
    return qde;




}

}
