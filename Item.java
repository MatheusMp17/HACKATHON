public class Item {
    int id;
    String nome;
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
