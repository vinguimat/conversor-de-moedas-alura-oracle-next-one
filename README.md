# 💱 Conversor de Moedas - Java (Console + API)

Este é um projeto Java simples e funcional que realiza **conversão de moedas** em tempo real, utilizando uma **API pública de câmbio**. A interface é baseada em console e permite conversões fixas (como USD para BRL) e personalizadas entre qualquer par de moedas suportadas pela API.

## 🚀 Funcionalidades

- Consulta em tempo real da taxa de câmbio via API
- Conversões pré-definidas (Dólar, Real, Peso Argentino, etc)
- Conversão personalizada entre qualquer moeda
- Interface interativa em console
- Tratamento de erros e validações de entrada

## 🖼️ Exemplo do menu no console

```
************************************
Bem vindo ao conversor de moedas

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileiro
4) Real brasileiro =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Dólar =>> Peso chileno
8) Peso chileno =>> Dólar
9) Dólar =>> Boliviano 
10) Boliviano =>> Dólar
11) Escolha sua própria conversão
12) Sair
Escolha uma opção válida:
************************************
```

## 🔧 Tecnologias e ferramentas utilizadas

- Java 17+
- [HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html) (nativo desde Java 11)
- JSON parsing com `org.json` (`JSONObject`)
- API: [ExchangeRate API](https://www.exchangerate-api.com/)

## 🔑 API Key

Use sua própria chave:
1. Cadastre-se em [exchangerate-api.com](https://www.exchangerate-api.com/)

## 🔐 Configuração da Chave da API

Este projeto utiliza a API gratuita [ExchangeRate API](https://www.exchangerate-api.com/) para obter as taxas de câmbio em tempo real.

Para utilizar o projeto:

1. Crie um arquivo chamado `config.properties` na raiz do projeto.
2. Dentro dele, insira sua chave de API no seguinte formato:

```properties
api.key=SUA_CHAVE_AQUI
```

## 🗂️ Estrutura do Projeto

```
src/
│
├── main/
│   ├── Main.java             # Ponto de entrada do programa
│   ├── menu/
│   │   └── Menu.java         # Interface de usuário no console
│   ├── service/
│   │   └── ExchangeRateService.java  # Responsável pela chamada à API
│   └── util/
│       └── CurrencyConverter.java    # Lógica de conversão de valores
```

## ⚙️ Como executar o projeto

1. Clone este repositório:
```bash
git clone https://github.com/vinguimat/conversor-de-moedas-alura-oracle-next-one.git
```

2. Importe em sua IDE Java (IntelliJ, Eclipse, VS Code)

3. Baixe a biblioteca `org.json`:
   - Via Maven:
     ```xml
     <dependency>
         <groupId>org.json</groupId>
         <artifactId>json</artifactId>
         <version>20240303</version>
     </dependency>
     ```
   - Ou adicione o JAR manualmente ao classpath

4. Execute `Main.java` (arquivo principal)

## ✨ Melhorias futuras

- Suporte a mais moedas e exibição de bandeiras
- Interface gráfica com JavaFX ou Swing
- Histórico de conversões
- Cache de taxas para reduzir chamadas repetidas

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para fazer um fork, abrir um PR ou relatar bugs.

## 📜 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 💬 Contato

Desenvolvido com 💻 por [vinguimat](https://github.com/vinguimat)
