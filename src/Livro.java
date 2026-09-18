public class Livro {

    private String tituloLivro;
    private String codigoDoLivro;
    private boolean alugado;
    private Usuario usuarioAluguel;

    public Livro(String tituloLivro) {

        this.tituloLivro = tituloLivro;
        this.alugado = false;
        this.usuarioAluguel = null;

    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {

        this.tituloLivro = tituloLivro;
    }

    public String getCodigoDoLivro() {
        return codigoDoLivro;
    }

    public void setCodigoDoLivro(String codigoDoLivro) {

        this.codigoDoLivro = codigoDoLivro;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public Usuario getUsuarioAluguel() {

        return usuarioAluguel;
    }

    public void alugar(Usuario usuario) {

        this.alugado = true;
        this.usuarioAluguel = usuario;
    }

    public void devolver() {
        this.alugado = false;
        this.usuarioAluguel = null;
    }

    @Override
    public String toString() {
        return "Livro " + tituloLivro + ", código do livro é: '" + codigoDoLivro + "'";

    }
}
