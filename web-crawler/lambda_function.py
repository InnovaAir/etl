import json

import requests

import tempfile

import os

import json

import boto3

from meteostat import Point, Daily

from datetime import datetime

from datetime import datetime

import csv

def lambda_handler(event, context):

    mes_atual = datetime.now().month
    ano_atual = datetime.now().year
    data = f"{ano_atual}{mes_atual:02d}"

    url = f"https://olinda.bcb.gov.br/olinda/servico/Pix_DadosAbertos/versao/v1/odata/EstatisticasTransacoesPix(Database=@Database)?@Database='{data}'&$top=1000&$filter=FINALIDADE%20eq%20'Pix'%20and%20AnoMes%20eq%20{data}&$format=text/csv&$select=AnoMes,VALOR,QUANTIDADE"   

    try:

        start = datetime(2020, 1, 1)
        end = datetime(2020, 12, 31)

        location = Point(-23.55, -46.63)

        data = Daily(location, start, end)
        data = data.fetch()

        print(data.head())

        toCsv = data.to_csv('/tmp/clima.csv')

        nome_arquivo = f"/tmp/pix{data}.csv"
        with open(nome_arquivo, 'w', newline='') as csvfile:
            csvfile.write(toCsv)

        nome_arquivoDestino = f"pix/pix{data}.csv"
        s3 = boto3.client('s3')
        s3.upload_file(nome_arquivo, 'bucket', nome_arquivoDestino)

    except requests.exceptions.RequestException as e:

        print(f"Erro na requisição: {e}")

        return None