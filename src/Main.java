import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
        ArrayList<Livro> listaDeLivros = new ArrayList<>();

        int contador = 1;
        int opcaoMenu = 0;
        boolean encontrouLivro;

        do {
            Menu.menu();
            opcaoMenu = leitor.nextInt();
            leitor.nextLine();

            switch (opcaoMenu) {

                case 1:
                    System.out.print("\nDigite o nome de usuário que deseja cadastrar: ");
                    Usuario nickname = new Usuario();
                    nickname.nome = leitor.nextLine();

                    listaDeUsuarios.add(nickname);

                    System.out.println("Digite seu CPF " + nickname.nome + ": ");
                    nickname.cpf = leitor.next();

                    System.out.print("\nUsuário " + nickname.nome + " que tem o CPF " + nickname.cpf + " foi cadastrado(a) com sucesso!\n");
                    break;

                case 2:
                    System.out.print("\nDigite o nome do livro que deseja cadastrar: ");
                    Livro novoLivro = new Livro();

                    novoLivro.tituloLivro = leitor.nextLine();
                    listaDeLivros.add(novoLivro);

                    System.out.print("\nDigite o código do livro que deseja cadastrar: ");
                    novoLivro.codigoDoLivro = leitor.nextLine();

                    System.out.print("\nLivro " + novoLivro.tituloLivro + " com código " + novoLivro.codigoDoLivro + " foi cadastrado com sucesso!\n");
                    break;

                case 3:
                    System.out.println("===== LISTA DE USUÁRIOS =====\n");
                    if (listaDeUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário foi encontrado, tente novamente.");
                    } else {
                        for (Usuario u : listaDeUsuarios) {
                            System.out.println("Usuário " + contador + ": " + u.nome);
                            contador++;
                        }
                        if (listaDeUsuarios.size() == 1) {
                            System.out.println("\nExiste  atualmente " + listaDeUsuarios.size() + " usuário.");
                        } else {
                            System.out.println("\nExistem  atualmente " + listaDeUsuarios.size() + " usuários.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("===== LISTA DE LIVROS =====");
                    if (listaDeLivros.isEmpty()) {
                        System.out.println("\nNenhum livro foi encontrado, tente novamente.");
                    } else {
                        for (Livro u : listaDeLivros) {
                            System.out.println("\nLivro " + contador + ": " + u.tituloLivro + ".\nSeu respectivo código é " + u.codigoDoLivro + ".");
                            contador++;
                        }
                        if (listaDeLivros.isEmpty()) {
                            System.out.println("\nExiste  atualmente " + listaDeLivros.size() + " livros.");
                        } else {
                            System.out.println("\nExistem  atualmente " + listaDeLivros.size() + " livros.");
                        }
                    }
                    break;
                case 5:
                    if (listaDeLivros.isEmpty()){
                    System.out.println("Não foi encontrado quais quer livros, tente novamente.");

                }else {
                        System.out.println("\nQual o livro que você quer alugar?");
                        for (int i = 0; i < listaDeLivros.size(); i++) {
                            System.out.println("\n" + listaDeLivros.get(i).toString());
                        }

                    }




            }

        } while (opcaoMenu != 9);
        System.out.println("\nSaindo da biblioteca, obrigado por utilizar!");
    }
}