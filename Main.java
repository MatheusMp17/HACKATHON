public class Main {
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int id, usuario;
        System.out.print("Gostaria de entrar como instituição ou pessoa?\n1- pessoa\n2- instituição");
        usuario = teclado.nextInt();

        if(usuario == 1) {
            System.out.print("Informe o seu CPF: ");
            id = teclado.nextInt();
            System.out.print("");
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
