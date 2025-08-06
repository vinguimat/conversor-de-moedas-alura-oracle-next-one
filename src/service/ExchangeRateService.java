package service;

import org.json.JSONObject;
import util.ApiKeyLoader;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {

    // Chave da API e URL base da API de câmbio
    private static final String API_KEY = ApiKeyLoader.carregarChave();
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double obterTaxaCambio(String from, String to) throws Exception {
        // Monta a URL completa com base na moeda de origem (from)
        String url = BASE_URL + from;

        // Cria um cliente HTTP para fazer a requisição
        HttpClient client = HttpClient.newHttpClient();

        // Cria o objeto de requisição GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Envia a requisição e captura a resposta como texto
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Converte a resposta para JSON
        JSONObject json = new JSONObject(response.body());

        // Verifica se a requisição foi bem-sucedida
        if (!json.getString("result").equals("success")) {
            throw new Exception("Falha ao obter taxa de câmbio.");
        }

        // Extrai o objeto "conversion_rates" do JSON
        JSONObject rates = json.getJSONObject("conversion_rates");

        // Verifica se a moeda de destino está presente
        if (!rates.has(to)) {
            throw new Exception("Moeda de destino não encontrada.");
        }

        // Retorna a taxa de câmbio para a moeda destino
        return rates.getDouble(to);
    }
}
