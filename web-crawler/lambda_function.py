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

    try:
        start = datetime(2020, 1, 1)
        end = datetime(2020, 12, 31)

        location = Point(-23.55, -46.63)

        data = Daily(location, start, end)
        data = data.fetch()

        data = data.reset_index()

        dadosFiltrados = data[['time', 'tavg', 'tmin', 'tmax', 'prcp', 'wspd']]

        dadosFiltrados.to_csv('/tmp/clima.csv', index=False, encoding='utf-8-sig')

        nome_arquivo = f"/tmp/clima{data}.csv"

        nome_arquivoDestino = f"clima/clima{data}.csv"
        s3 = boto3.client('s3')
        s3.upload_file(nome_arquivo, 'bucket', nome_arquivoDestino)

    except requests.exceptions.RequestException as e:

        print(f"Erro na requisição: {e}")

        return None