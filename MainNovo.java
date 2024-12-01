import java.util.Scanner;
public class MainNovo {
    // pede informaçoes, escolher entre pedir e ajudar, 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Item  doacao;
        int id, usuario, num;
        String email;
        Endereco endereco;
        System.out.print("Gostaria de entrar como instituição ou pessoa?\n1- pessoa\n2- instituição");
        usuario = teclado.nextInt();
        

        if(usuario == 1) {
            System.out.print("Informe o seu CPF: ");
            id = teclado.nextInt();
            

            System.out.print("\nInforme seu Bairro: ");
            endereco.setBairro(teclado.next());
            System.out.print("\nInforme seu Rua: ");
            endereco.setRua(teclado.next());
            System.out.print("\nInforme seu número: ");
            endereco.setNumero(teclado.nextInt());

            System.out.print("\nInforme seu email: ");
            email = teclado.next();

            System.out.print("Escolha 1 para receber ajuda e 2 para prestar ajuda:");
            num = teclado.nextInt();
            switch (num) {
                case 1:
                System.out.println(
                "informe suas necessidades: \n"
                +"[1]Itens de higiene"
                +"[2]Alimentos"
                +"[3]roupas"
                +"[4]Conforto"
                +"[5]Móveis"
                +"[6]Serviço voluntário"
                +"[7]Dinheiro");
                num = teclado.nextInt();
                switch (num) {
                    case 1:
                        doacao.setTipo(TipoDoacao.itensDeHigiene);
                        break;
                    case 2:
                        doacao.setTipo(TipoDoacao.Alimentos);
                        break;
                    case 3:
                        doacao.setTipo(TipoDoacao.Roupas);
                        break;
                    case 4:
                        doacao.setTipo(TipoDoacao.conforto);
                        break;
                    case 5:
                        doacao.setTipo(TipoDoacao.moveis); 
                        break;
                    case 6:
                        doacao.setTipo(TipoDoacao.voluntariado);
                        break;
                    case 7:
                        doacao.setTipo(TipoDoacao.dinheiro);
                        break;            
                    default:
                        break;
                }

                
                    PessoaVitima pessoaVitima = new PessoaVitima(id, endereco, email, doacao);
                    break;
            
                default:
                    break;
            }
        }
    }
}

