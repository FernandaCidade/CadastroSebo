import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodosLivros = new Livro();

        System.out.println("Bem vindo ao Sebo!");
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Cadastrar livro / 2 - Listar livros / 0 - sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.print("Digite o titulo do livro: ");
                    novoLivro.titulo = scanner.next();

                    System.out.print("Digite o nome do autor do livro: ");
                    novoAutor.nome = scanner.next();

                    System.out.print("Digite o local de nascimento do autor: ");
                    novoAutor.localNasc = scanner.next();

                    System.out.print("Digite o preço do livro: ");
                    novoLivro.preco = scanner.nextFloat();

                    System.out.print("Digite a data de Lançamento do livro: (dd/MM/yyyy) ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;

                    if (periodo.getYears() >= 5) {
                        System.out.println("O livro tem mais de 5 anos de lançamento");

                        novoLivro.autor = novoAutor;
                        listaLivro.add(novoLivro);

                        System.out.println("Cadastro realizado com sucesso!");
                        break;

                    } else {
                        System.out.println("Livro tem menos de 5 anos de lançamento. Cadatro invalido");
                        break;
                    }



                case 2:

                    if(listaLivro.size() > 0){
                        for(Livro cadaLivro : listaLivro){
                            System.out.println();
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local de Nascimento: " + cadaLivro.autor.localNasc);
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println("Data de Lançamento" + cadaLivro.dataLancamento);
                        }
                    } else {
                        System.out.println("Lista vazia");
                    }
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema!");
                    break;

                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida!");
            }


        }while ( opcao != 0);
    }
}