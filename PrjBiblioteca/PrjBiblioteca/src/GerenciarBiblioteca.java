public class GerenciarBiblioteca {
    public static void main(String[] args) {

        Aluno aluno = new Aluno(1, "João Silva", "joao@email.com", "20231234", "Engenharia");
        Professor professor = new Professor(2, "Maria Souza", "maria@email.com", "Matemática", "Doutor");
        Funcionario funcionario = new Funcionario(3, "Pedro Oliveira", "pedro@email.com", "Bibliotecário", "Administração");

        Livro livro1 = new Livro(1, "Java para Iniciantes", "Autor A", true);
        Livro livro2 = new Livro(2, "Estruturas de Dados", "Autor B", true);

        ControleEmprestimo controle = new ControleEmprestimo();

        System.out.println(controle.registraEmprestimo(aluno, livro1));
        System.out.println(controle.registraEmprestimo(professor, livro2));

        System.out.println(controle.registraDevolucao(aluno, livro1));
        System.out.println(controle.registraDevolucao(professor, livro2));
    }
}
