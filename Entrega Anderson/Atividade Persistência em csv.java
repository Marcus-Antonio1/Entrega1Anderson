import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    // Método para escrever dados em um arquivo CSV
    public static void escreverCSV(String nomeArquivo, List<String[]> dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String[] linha : dados) {
                String linhaCSV = String.join(",", linha);
                writer.write(linhaCSV);
                writer.newLine();
            }
            System.out.println("Dados foram gravados no arquivo CSV com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler dados de um arquivo CSV
    public static List<String[]> lerCSV(String nomeArquivo) {
        List<String[]> dados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                dados.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    public static void main(String[] args) {
        // Exemplo de dados que queremos persistir
        List<String[]> dados = new ArrayList<>();
        dados.add(new String[] { "Nome", "Idade", "Cidade" });
        dados.add(new String[] { "João", "30", "São Paulo" });
        dados.add(new String[] { "Maria", "25", "Rio de Janeiro" });
        dados.add(new String[] { "Pedro", "35", "Belo Horizonte" });

        // Escrever dados em um arquivo CSV
        escreverCSV("dados.csv", dados);

        // Ler dados do arquivo CSV
        List<String[]> dadosLidos = lerCSV("dados.csv");
        for (String[] linha : dadosLidos) {
            for (String campo : linha) {
                System.out.print(campo + "\t");
            }
            System.out.println();
        }
    }
}
