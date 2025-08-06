package menu;

import service.ExchangeRateService;
import util.CurrencyConverter;

import java.util.Scanner;

public class Menu {

    public static void exibir() {
        Scanner scanner = new Scanner(System.in); // Lê entradas do usuário
        ExchangeRateService service = new ExchangeRateService(); // Instância do serviço que chama a API
        boolean continuar = true;

        while (continuar) {
            // Mostra o menu de opções
            System.out.println("************************************");
            System.out.println("Bem vindo ao conversor de moedas");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Peso chileno");
            System.out.println("8) Peso chileno =>> Dólar");
            System.out.println("9) Dólar =>> Boliviano boliviano");
            System.out.println("10) Boliviano boliviano =>> Dólar");
            System.out.println("11) Escolha sua própria conversão");
            System.out.println("12) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("************************************");

            int opcao;

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } else {
                // Entrada inválida — mostra mensagem e pula a iteração do loop
                System.out.println("Entrada inválida. Por favor, digite um número entre 1 e 12.");
                scanner.nextLine(); // Consome a entrada inválida
                continue; // Retorna ao início do loop
            }


            if (opcao == 12) {
                // Encerra o programa
                continuar = false;
                System.out.println("Encerrando...");
                break;
            }

            String from = ""; // Moeda de origem
            String to = "";   // Moeda de destino

            // Define as moedas com base na opção escolhida
            switch (opcao) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "ARS"; to = "USD"; }
                case 3 -> { from = "USD"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
                case 7 -> { from = "USD"; to = "CLP"; }
                case 8 -> { from = "CLP"; to = "USD"; }
                case 9 -> { from = "USD"; to = "BOB"; }
                case 10 -> { from = "BOB"; to = "USD"; }
                case 11 -> {
                    System.out.println("Qual a moeda a ser convertida? ex: USD");
                    from = scanner.nextLine().toUpperCase();
                    System.out.println("Agora a moeda destinada ex: EUR");
                    to = scanner.nextLine().toUpperCase();
                }
                default -> {
                    System.out.println("Opção inválida.");
                    continue; // Retorna ao início do loop
                }
            }

            // Solicita o valor para conversão
            System.out.println("Digite o valor a ser convertido:");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            try {
                // Obtém a taxa de câmbio da API
                double taxa = service.obterTaxaCambio(from, to);

                // Faz a conversão usando a taxa
                double convertido = CurrencyConverter.converter(valor, taxa);

                // Mostra o resultado no console
                System.out.printf("%.2f %s = %.2f %s%n", valor, from, convertido, to);
                System.out.printf("Taxa: 1 %s = %.4f %s%n", from, taxa, to);
            } catch (Exception e) {
                // Exibe erro caso a conversão falhe
                System.out.printf("Erro ao converter de %s para %s: %s%n", from, to, e.getMessage());
            }
        }
        // Fecha o scanner ao final
        scanner.close();
    }
}
