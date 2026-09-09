public class Livro {

    String tituloLivro;
    String codigoDoLivro;

    @Override
    public String toString() {
        return "Livro '" + tituloLivro + "'" +
                ", código do livro é: '" + codigoDoLivro + "'";
    }
}

