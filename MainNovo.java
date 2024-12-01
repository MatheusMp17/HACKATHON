import java.util.Scanner;
public class MainNovo {
    // pede informaçoes, escolher entre pedir e ajudar, 
    public static void main(String[] args) {
      /*  Scanner teclado = new Scanner(System.in);
        Item  doacao;
        int id, usuario, num, qtd;
        String email;
        Endereco endereco = new Endereco();
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
                +"[3]Roupas"
                +"[4]Conforto"
                +"[5]Móveis"
                +"[6]Serviço voluntário"
                +"[7]Dinheiro");
                num = teclado.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Informe a quantididade de recursos do tipo itens de higiene que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.itensDeHigiene.getNome(),TipoDoacao.itensDeHigiene, qtd,  false);
                        break;
                    case 2:
                        System.out.println("Informe a quantididade de recursos do tipo alimentos que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.Alimentos.getNome(),TipoDoacao.Alimentos, qtd,  false);
                        break;
                    case 3:
                        System.out.println("Informe a quantididade de recursos do tipo dinheiro que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.dinheiro.getNome(),TipoDoacao.dinheiro, qtd,  false);
                        break;
                    case 4:
                        System.out.println("Informe a quantididade de recursos do tipo dinheiro que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.dinheiro.getNome(),TipoDoacao.dinheiro, qtd,  false);
                        break;
                    case 5:
                        System.out.println("Informe a quantididade de recursos do tipo dinheiro que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.dinheiro.getNome(),TipoDoacao.dinheiro, qtd,  false); 
                        break;
                    case 6:
                        System.out.println("Informe a quantididade de recursos do tipo dinheiro que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.dinheiro.getNome(),TipoDoacao.dinheiro, qtd,  false);
                        break;
                    case 7:
                        System.out.println("Informe a quantididade de recursos do tipo dinheiro que você está disposto a doar");   
                        qtd = teclado.nextInt();
                        doacao  = new Item(id, TipoDoacao.dinheiro.getNome(),TipoDoacao.dinheiro, qtd,  false);
                        break;            
                    default:
                        break;
                }

                 PessoaVitima pessoaVitima = new PessoaVitima(id, endereco, email, doacao);
                    break;
            
                default:
                    break;
            }
        }*/
    }
}

