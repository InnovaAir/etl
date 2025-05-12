import json

import requests

import tempfile

import os

import json

import boto3

from datetime import datetime

import csv

def lambda_handler(event, context):

    mes_atual = datetime.now().month
    ano_atual = datetime.now().year
    data = f"{ano_atual}{mes_atual:02d}"

    url ="https://olinda.bcb.gov.br/olinda/servico/Pix_DadosAbertos/versao/v1/odata/EstatisticasTransacoesPix(Database=@Database)?@Database='" + data + "'&$top=1000&$filter=FINALIDADE%20eq%20'Pix'%20and%20AnoMes%20eq%20" + data + "&$format=text/csv&$select=AnoMes,VALOR,QUANTIDADE"   

    try:

        resultado = requests.get(url)
        resultado.raise_for_status()

        nome_arquivo = f"/tmp/pix{data}.csv"
        with open(nome_arquivo, 'w', newline='') as csvfile:
            csvfile.write(resultado.text)

        nome_arquivoDestino = f"pix/pix{data}.csv"
        s3 = boto3.client('s3')
        s3.upload_file(nome_arquivo, 'bucket', nome_arquivoDestino)

    except requests.exceptions.RequestException as e:

        print(f"Erro na requisição: {e}")

        return None

print(lambda_handler(None, None))