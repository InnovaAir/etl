import json

import requests

import tempfile

import os

import json

import boto3

from datetime import datetime

 

def lambda_handler(event, context):

    mes_atual = datetime.now().month
    ano_atual = datetime.now().year
    data = f"{ano_atual}{mes_atual:02d}"

    url ="https://olinda.bcb.gov.br/olinda/servico/Pix_DadosAbertos/versao/v1/odata/EstatisticasTransacoesPix(Database=@Database)?@Database='" + data + "'&$top=1000&$filter=FINALIDADE%20eq%20'Pix'%20and%20AnoMes%20eq%20" + data + "&$format=text/csv&$select=AnoMes,VALOR,QUANTIDADE"   

    try:

        resultado = requests.get(url)

        

        # Verifica se a requisição foi bem-sucedida

        resultado.raise_for_status()


        # Gero o arquivo json

        nome_arquivo = os.path.join(tempfile.gettempdir(), 'dados.json')

        with open(nome_arquivo, mode='wt') as f:

            json.dump(transacoes, f)

           

        # Upload para o s3

        s3 = boto3.client('s3')

        s3.upload_file(

            Filename=nome_arquivo,

            Bucket='my-python-bucket-01',

            Key='pix/dados.json'

        )

        

        return transacoes

    

    except requests.exceptions.RequestException as e:

        print(f"Erro na requisição: {e}")

        return None

    

    except json.JSONDecodeError as e:

        print(f"Erro ao decodificar JSON: {e}")

        print(f"Resposta completa da API: {resultado.text}")

        return None

 

print(lambda_handler(None, None))

