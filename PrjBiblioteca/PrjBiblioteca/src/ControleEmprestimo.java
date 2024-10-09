import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControleEmprestimo {
    private List<RegistroEmprestimo> registros = new ArrayList<>();
    private int contadorEmprestimos = 1;

    public String registraEmprestimo(Usuario usuario, Livro livro) {
        if (!livro.isDisponivel()) {
            return "O livro " + livro.getTitulo() + " já está emprestado.";
        }

        livro.setDisponivel(false);
        LocalDate dataEmprestimo = LocalDate.now();
        RegistroEmprestimo registro = new RegistroEmprestimo(contadorEmprestimos++, usuario, livro, dataEmprestimo, null);
        registros.add(registro);

        return "Empréstimo realizado com sucesso:\n" +
                "Usuário: " + usuario.getNome() + "\n" +
                "Livro: " + livro.getTitulo() + "\n" +
                "Data do Empréstimo: " + dataEmprestimo;
    }

    // Método para registrar a devolução de um livro
    public String registraDevolucao(Usuario usuario, Livro livro) {
        for (RegistroEmprestimo registro : registros) {
            if (registro.getUsuario().equals(usuario) && registro.getLivro().equals(livro) && registro.getDataDevolucao() == null) {
                registro.setDataDevolucao(LocalDate.now());
                livro.setDisponivel(true);

                return "Devolução realizada com sucesso:\n" +
                        "Usuário: " + usuario.getNome() + "\n" +
                        "Livro: " + livro.getTitulo() + "\n" +
                        "Data da Devolução: " + registro.getDataDevolucao();
            }
        }
        return "Nenhum empréstimo encontrado para este usuário e livro.";
    }
}
