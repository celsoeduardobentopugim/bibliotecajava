import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String isbn;

    // Construtor, getters e setters
}

class Usuario {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    // Construtor, getters e setters
}

class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private String dataEmprestimo;
    private String prazoDevolucao;
    private String dataDevolucao;

    // Construtor, getters e setters
}

class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void registrarDevolucao(Emprestimo emprestimo, String dataDevolucao) {
        emprestimo.setDataDevolucao(dataDevolucao);
    }

    public List<Livro> consultarAcervoPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> consultarAcervoPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> consultarAcervoPorISBN(String isbn) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public Map<Livro, Integer> gerarRelatorioEmprestimos() {
        Map<Livro, Integer> relatorio = new HashMap<>();
        for (Emprestimo emprestimo : emprestimos) {
            Livro livro = emprestimo.getLivro();
            int quantidade = relatorio.getOrDefault(livro, 0);
            relatorio.put(livro, quantidade + 1);
        }
        return relatorio;
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Exemplo de uso: cadastrar um livro
        Livro livro1 = new Livro();
        livro1.setTitulo("Dom Quixote");
        livro1.setAutor("Miguel de Cervantes");
        livro1.setEditora("Editora XYZ");
        livro1.setAnoPublicacao(1605);
        livro1.setIsbn("9781234567890");
        biblioteca.cadastrarLivro(livro1);

        // Exemplo de uso: cadastrar um usuário
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setEndereco("Rua ABC, 123");
        usuario1.setTelefone("(11) 99999-9999");
        usuario1.setEmail("joao@example.com");
        biblioteca.cadastrarUsuario(usuario1);

        // Exemplo de uso: registrar um empréstimo
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setLivro(livro1);
        emprestimo1.setUsuario(usuario1);
        emprestimo1.setDataEmprestimo("2024-03-19");
        emprestimo1.setPrazoDevolucao("2024-04-19");
        biblioteca.registrarEmprestimo(emprestimo1);

        // Exemplo de uso: consultar acervo por título
        List<Livro> livrosPorTitulo = biblioteca.consultarAcervoPorTitulo("Dom Quixote");
        for (Livro livro : livrosPorTitulo) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }

        // Exemplo de uso: gerar relatório de empréstimos
        Map<Livro, Integer> relatorioEmprestimos = biblioteca.gerarRelatorioEmprestimos();
        for (Map.Entry<Livro, Integer> entry : relatorioEmprestimos.entrySet()) {
            Livro livro = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println(livro.getTitulo() + " - " + quantidade + " empréstimos");
        }
    }
}