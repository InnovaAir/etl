import json

import requests

import tempfile

import os

import boto3

from meteostat import Point, Daily

from datetime import datetime

from dateutil.relativedelta import relativedelta

import pandas as pd

def lambda_handler(event, context):
    try:
        hoje = datetime.now()

        tres_meses_atras = hoje - relativedelta(months=3)

        start = tres_meses_atras
        end = hoje

        location = Point(-23.55, -46.63)

        data = Daily(location, start, end)
        data = data.fetch()

        data = data.reset_index()
        dadosFiltrados = data[['time', 'tavg', 'tmin', 'tmax', 'prcp', 'wspd']]

        dadosFiltrados = dadosFiltrados.fillna(0.0)

        nome_arquivo = '/tmp/clima.csv'
        dadosFiltrados.to_csv(nome_arquivo, index=False, encoding='utf-8-sig')

        nome_arquivo_destino = f"clima/clima_{hoje.strftime('%Y-%m-%d')}.csv"

        s3 = boto3.client('s3')
        s3.upload_file(nome_arquivo, 'bucket', nome_arquivo_destino)

        return {
            'statusCode': 200,
            'body': json.dumps('Arquivo enviado com sucesso!')
        }

    except Exception as e:
        print(f"Erro: {e}")
        return {
            'statusCode': 500,
            'body': json.dumps(f"Erro: {e}")
        }
