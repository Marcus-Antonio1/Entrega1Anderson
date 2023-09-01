import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Pessoa {
    private int id;
    private String nome;

    // Construtor vazio necessário para a desserialização JSON
    public Pessoa() {
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters (necessários para a serialização/desserialização)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
        // Criar uma instância da classe Pessoa
        Pessoa pessoa = new Pessoa(1, "João da Silva");

        // Criar um objeto ObjectMapper (parte da biblioteca Jackson)
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serialização: Convertendo a instância Pessoa em JSON e salvando em um arquivo
            objectMapper.writeValue(new File("pessoa.json"), pessoa);
            System.out.println("Dados da pessoa foram serializados em JSON com sucesso.");

            // Desserialização: Lendo o JSON do arquivo e convertendo-o de volta para uma instância Pessoa
            Pessoa pessoaDesserializada = objectMapper.readValue(new File("pessoa.json"), Pessoa.class);
            System.out.println("Dados da pessoa foram desserializados do JSON com sucesso.");

            // Exibir os dados da pessoa desserializada
            System.out.println("ID: " + pessoaDesserializada.getId());
            System.out.println("Nome: " + pessoaDesserializada.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class App 
{
    public static void main( String[] args ) {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, getPessoas());
            System.out.println("JSON gerado:");
            System.out.println(writer);

            // Deserialize
            String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
            List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
            System.out.println("\nPessoas desserializadas:");
            for (Pessoa pessoa : p) {
                System.out.println("ID: " + pessoa.getId() + ", Nome: " + pessoa.getNome());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;
    }
}
