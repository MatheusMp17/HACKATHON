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

     
   // public static ArrayList<String> ItemDoacao = new ArrayList<>();
           //       ArrayList<String> ItemNecessario = new ArrayList<>();

    
}

