import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class ExtracaoDadosIBGE {

    public static void main(String[] args) {
        try {
            // URL do site do IBGE 
            String url = "https://www.ibge.gov.br/";

            // Conecta ao site e obtém o conteúdo HTML
            Document document = Jsoup.connect(url).get();

        
            Elements dadosPopulacao = document.select(".classeCSS"); // Substitua com o seletor apropriado

            // Crie um arquivo CSV para armazenar os dados extraídos
            FileWriter csvWriter = new FileWriter("dados_ibge.csv");

            // Itera pelos elementos e escreve-os no arquivo CSV
            for (Element dado : dadosPopulacao) {
                String textoDado = dado.text();
                csvWriter.append(textoDado);
                csvWriter.append("\n");
            }

            // Feche o arquivo CSV
            csvWriter.close();

            System.out.println("Dados extraídos e armazenados em dados_ibge.csv.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
