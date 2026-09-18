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

                    String nomeUsuario = leitor.nextLine();

                    System.out.print("\nDigite seu CPF " + nomeUsuario + ": ");
                    String cpfUsuario = leitor.nextLine();

                    Usuario nickname = new Usuario(cpfUsuario);
                    nickname.setNome(nomeUsuario);

                    listaDeUsuarios.add(nickname);

                    System.out.print("\nUsuário " + nickname.getNome() + " que tem o CPF " + nickname.getCpf() + " foi cadastrado(a) com sucesso!\n");
                    break;

                case 2:
                    System.out.print("\nDigite o nome do livro que deseja cadastrar: ");
                    String tituloLivro = leitor.nextLine();

                    Livro novoLivro = new Livro(tituloLivro);

                    System.out.print("\nDigite o código do livro que deseja cadastrar: ");
                    novoLivro.setCodigoDoLivro(leitor.nextLine());

                    listaDeLivros.add(novoLivro);

                    System.out.println("\nLivro " + novoLivro.getTituloLivro() + " com código " + novoLivro.getCodigoDoLivro() + " foi cadastrado com sucesso!\n");
                    break;

                case 3:
                    System.out.println("\n===== LISTA DE USUÁRIOS =====\n");

                    if (listaDeUsuarios.isEmpty()) {

                        System.out.println("Nenhum usuário foi encontrado, tente novamente.");
                    } else {
                        int contadorUsuarioLista = 1;

                        for (Usuario u : listaDeUsuarios) {

                            System.out.println("Usuário " + contadorUsuarioLista
                                    + ": " + u.getNome());

                            contadorUsuarioLista++;
                        }

                        if (listaDeUsuarios.size() == 1) {
                            System.out.println("\nExiste atualmente "
                                    + listaDeUsuarios.size() + " usuário.");
                        } else {
                            System.out.println("\nExistem atualmente "
                                    + listaDeUsuarios.size() + " usuários.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n===== LISTA DE LIVROS =====");

                    if (listaDeLivros.isEmpty()) {

                        System.out.println("\nNenhum livro foi encontrado, tente novamente.");
                    } else {
                        int contadorLivroLista = 1;

                        for (Livro livro : listaDeLivros) {

                            System.out.println("\nLivro " + contadorLivroLista
                                    + ": " + livro.getTituloLivro()
                                    + ".\nSeu respectivo código é "
                                    + livro.getCodigoDoLivro() + ".");

                            if (livro.isAlugado()) {
                                System.out.println("Status: ALUGADO por "
                                        + livro.getUsuarioAluguel().getNome());
                            } else {
                                System.out.println("Status: DISPONÍVEL");
                            }

                            contadorLivroLista++;
                        }

                        if (listaDeLivros.size() == 1) {
                            System.out.println("\nExiste atualmente "
                                    + listaDeLivros.size() + " livro.");
                        } else {
                            System.out.println("\nExistem atualmente "
                                    + listaDeLivros.size() + " livros.");
                        }
                    }
                    break;

                case 5:
                    int contadorUsuario = 1;

                    if (listaDeUsuarios.isEmpty()) {
                        System.out.println("\nNão há usuários cadastrados.");
                        break;
                    }
                    if (listaDeLivros.isEmpty()) {
                        System.out.println("\nNão há livros cadastrados.");
                        break;
                    }
                    System.out.println("\n===== ALUGAR LIVRO =====");
                    System.out.println("\nEscolha qual usuário deseja alugar um livro:\n");

                    for (Usuario user : listaDeUsuarios) {

                        System.out.println("[" + contadorUsuario + "] - " + user.getNome());

                        contadorUsuario++;
                    }
                    System.out.print("\nEscolha o número do usuário: ");
                    int numeroDoUsuario = leitor.nextInt();

                    if (numeroDoUsuario < 1 || numeroDoUsuario > listaDeUsuarios.size()) {

                        System.out.println("\nNúmero de usuário inválido, tente novamente.");
                        break;
                    }
                    Usuario usuarioEscolhido = listaDeUsuarios.get(numeroDoUsuario - 1);

                    int contadorLivro = 1;

                    System.out.println("\n" + usuarioEscolhido.getNome() + ", escolha seu livro:\n");

                    for (Livro book : listaDeLivros) {

                        if (!book.isAlugado()) {

                            System.out.println("[" + contadorLivro + "] - " + book.getTituloLivro() + " [DISPONÍVEL]");
                        } else {
                            System.out.println("[" + contadorLivro + "] - " + book.getTituloLivro() + " [ALUGADO] " + "por " + book.getUsuarioAluguel().getNome());
                        }
                        contadorLivro++;
                    }

                    System.out.print("\n" + usuarioEscolhido.getNome() + ", escolha o número do livro para alugar: ");
                    int numeroDoLivro = leitor.nextInt();

                    if (numeroDoLivro < 1 || numeroDoLivro > listaDeLivros.size()) {

                        System.out.println("\nNúmero de livro inválido.");
                        break;
                    }
                    Livro livroEscolhido = listaDeLivros.get(numeroDoLivro - 1);

                    if (livroEscolhido.isAlugado()) {

                        System.out.println("\nEsse livro já está alugado pelo usuário " + livroEscolhido.getUsuarioAluguel().getNome() + ".");
                        System.out.println("O usuário " + livroEscolhido.getUsuarioAluguel().getNome() + " precisa devolver o livro antes que ele possa ser alugado novamente.");
                    } else {
                        livroEscolhido.alugar(usuarioEscolhido);

                        System.out.println("\nSeu livro foi alugado com sucesso.\n");
                        System.out.println("Usuário " + usuarioEscolhido.getNome() + " alugou o livro " + livroEscolhido.getTituloLivro() + ".");
                    }

                    break;

                case 6:
                    System.out.println("\n===== DEVOLVER LIVRO =====\n");
                    System.out.print("Digite o nome do usuário que alugou o livro: ");

                    String nome = leitor.nextLine();
                    Usuario usuarioEncontrado = null;

                    for (Usuario u : listaDeUsuarios) {
                        if (u.getNome().equalsIgnoreCase(nome)) {
                            usuarioEncontrado = u;
                            break;
                        }
                    }
                    if (usuarioEncontrado == null) {
                        System.out.println("\nUsuário não encontrado.");
                        break;
                    }
                    Livro livroDoUsuario = null;

                    for (Livro book : listaDeLivros) {
                        if (book.isAlugado() && book.getUsuarioAluguel() == usuarioEncontrado) {
                            livroDoUsuario = book;

                            break;
                        }
                    }
                    if (livroDoUsuario == null) {
                        System.out.println("\nEsse usuário não possui nenhum livro alugado.");
                        break;
                    }
                    livroDoUsuario.devolver();

                    System.out.println("\nLivro devolvido com sucesso.");

                    System.out.println("\nUsuário: " + usuarioEncontrado.getNome());
                    System.out.println("\nLivro: " + livroDoUsuario.getTituloLivro());
                    System.out.println("\nCódigo: " + livroDoUsuario.getCodigoDoLivro());

                    break;

                case 7:
                    System.out.println("\n===== CONSULTAR LIVRO =====\n");
                    System.out.print("Digite o código do livro que deseja consultar: ");

                    String codigoConsulta = leitor.nextLine();

                    Livro livroEncontrado = null;

                    for (Livro livro : listaDeLivros) {

                        if (livro.getCodigoDoLivro().equalsIgnoreCase(codigoConsulta)) {
                            livroEncontrado = livro;
                            break;
                        }
                    }

                    if (livroEncontrado == null) {
                        System.out.println("\nNenhum livro foi encontrado com esse código.");
                    } else {
                        System.out.println("\n===== LIVRO ENCONTRADO =====\n");
                        System.out.println("Título: " + livroEncontrado.getTituloLivro());
                        System.out.println("Código: " + livroEncontrado.getCodigoDoLivro());

                        if (livroEncontrado.isAlugado()) {
                            System.out.println("Status: ALUGADO");
                            System.out.println("Alugado por: " + livroEncontrado.getUsuarioAluguel().getNome());
                        } else {
                            System.out.println("Status: DISPONÍVEL");
                        }
                    }
                    break;

                case 8:
                    System.out.println("\n===== LIVROS ALUGADOS POR USUÁRIO =====\n");

                    if (listaDeUsuarios.isEmpty()) {
                        System.out.println("Não há usuários cadastrados.");
                        break;
                    }
                    if (listaDeLivros.isEmpty()) {
                        System.out.println("Não há livros cadastrados.");
                        break;
                    }

                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuarioConsulta = leitor.nextLine();

                    Usuario usuarioConsulta = null;

                    for (Usuario usuario : listaDeUsuarios) {

                        if (usuario.getNome().equalsIgnoreCase(nomeUsuarioConsulta)) {
                            usuarioConsulta = usuario;
                            break;
                        }
                    }
                    if (usuarioConsulta == null) {
                        System.out.println("\nUsuário não encontrado.");
                        break;
                    }
                    int contadorLivrosUsuario = 0;

                    System.out.println("\n===== LIVROS DE " + usuarioConsulta.getNome().toUpperCase() + " =====");

                    for (Livro livro : listaDeLivros) {

                        if (livro.isAlugado()
                                && livro.getUsuarioAluguel() == usuarioConsulta) {

                            System.out.println("\nTítulo: " + livro.getTituloLivro());
                            System.out.println("Código: " + livro.getCodigoDoLivro());

                            contadorLivrosUsuario++;
                        }
                    }
                    if (contadorLivrosUsuario == 0) {

                        System.out.println("\nEsse usuário não possui nenhum livro alugado.");

                    } else if (contadorLivrosUsuario == 1) {
                        System.out.println("\n" + usuarioConsulta.getNome() + " possui 1 livro alugado.");

                    } else {
                        System.out.println("\n" + usuarioConsulta.getNome() + " possui " + contadorLivrosUsuario + " livros alugados.");
                    }
                    break;

            }

        } while (opcaoMenu != 9);
        System.out.println("\nSaindo da biblioteca, obrigado por utilizar.");
    }
}
