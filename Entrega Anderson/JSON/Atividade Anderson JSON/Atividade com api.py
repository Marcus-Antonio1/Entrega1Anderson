import requests
import json

# Chave de API da OpenWeatherMap aqui por não ser uma api publica tem que fazer um cadastro no site pra pegar a chave e poder usar
api_key = "8830d85dbcfaae4406a4a477d51b4dbe"

# A URL da API para obter dados de previsão do tempo
cidade = "Campina Grande"  # Nome da cidade que vai obter dados
url = f"http://api.openweathermap.org/data/2.5/weather?q={cidade}&appid={api_key}&units=metric"

# Faz uma solicitação GET para obter os dados da API.
# Função get() da biblioteca requests e passa a URL como argumento. Isso retorna uma resposta do servidor, que transforma em dados JSON (ou outros formatos) usando o método .json().
# Response é a resposta do servidor e data contém os dados retornados na forma de um dicionário Python.
# Pode acessar os dados que deseja do dicionário data.
# seleciona os atributos que deseja usar para criar um novo dicionário chamado atributos_selecionados.
# No fim converte atributos_selecionados em formato JSON e o salva em um arquivo JSON usando a biblioteca json  
response = requests.get(url)
data = response.json()

# Selecione 6 atributos relevantes
# Tentei colocar em português mas só deu certo em inglês
atributos_selecionados = {
    "cidade": data["name"],
    "país": data["sys"]["country"],
    "temperatura": data["main"]["temp"],
    "umidade": data["main"]["humidity"],
    "condicao_clima": data["weather"][0]["description"],
    "velocidade_vento": data["wind"]["speed"]
}

# Converte os dados selecionados para formato JSON
dados_json = json.dumps(atributos_selecionados, indent=4, ensure_ascii=False)

# Salva os dados em um arquivo JSON
dado_clima = "dados_clima.json"
with open(dado_clima, "w", encoding="utf-8") as arquivo_json:
    arquivo_json.write(dados_json)

print(f"Dados convertidos e salvos em '{dado_clima}'.")

