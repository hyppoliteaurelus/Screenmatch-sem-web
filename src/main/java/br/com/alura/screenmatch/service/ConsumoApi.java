package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    // Definição do método obterDados que recebe uma String como parâmetro.
    public String obterDados(String endereco) {
        // Criação de um novo cliente HttpClient.
        HttpClient client = HttpClient.newHttpClient();
        // Criação de uma nova requisição HttpRequest utilizando o Builder Pattern.
        // O Builder Pattern é usado para construir objetos HttpRequest de maneira mais fluente.
        // Neste caso, estamos configurando a URI da requisição com o endereço fornecido.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // Declaração de uma variável para armazenar a resposta da requisição HTTP.
        HttpResponse<String> response = null;
        // Início do bloco try-catch para lidar com exceções durante o envio da requisição.
        try {
            // Envio da requisição HTTP e recebimento da resposta.
            // A resposta é armazenada na variável 'response'.
            // HttpResponse.BodyHandlers.ofString() é usado para tratar o corpo da resposta como uma String.
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Captura de exceção do tipo IOException, que pode ocorrer durante a comunicação de rede.

        } catch (IOException e) {

            // Lançamento de uma RuntimeException encapsulando a exceção original.
            // Isso interrompe a execução do método e propaga a exceção para quem o chamou.
            throw new RuntimeException(e);
            // Captura de exceção do tipo InterruptedException, que pode ocorrer se a thread for interrompida enquanto aguarda a resposta.
        } catch (InterruptedException e) {

            // Lançamento de uma RuntimeException encapsulando a exceção original.
            // Isso interrompe a execução do método e propaga a exceção para quem o chamou.

            throw new RuntimeException(e);
        }

        // Obtenção do corpo da resposta HTTP, que geralmente é um JSON, e armazenamento em uma variável 'json'.
        String json = response.body();
        return json;
    }
}
