import json
import requests
import tempfile
import os
import boto3
from meteostat import Point, Daily
from datetime import datetime
from dateutil.relativedelta import relativedelta
import pandas as pd

# Configurações AWS (substitua pelas suas credenciais ou use variáveis de ambiente)
AWS_ACCESS_KEY_ID = ''
AWS_SECRET_ACCESS_KEY = ''
AWS_SESSION_TOKEN = ''
AWS_REGION = ''
BUCKET_NAME = ''

def main():
    try:
        hoje = datetime.now()
        tres_meses_atras = hoje - relativedelta(months=3)

        start = tres_meses_atras
        end = hoje

        location = Point(-23.55, -46.63)

        data = Daily(location, start, end)
        data = data.fetch()

        data = data.reset_index()
        dadosFiltrados = data[['time', 'tavg', 'prcp', 'wspd']].fillna(0.0)

        nome_arquivo = 'clima.csv'
        dadosFiltrados.to_csv(nome_arquivo, index=False, encoding='utf-8-sig')

        nome_arquivo_destino = f"clima/clima_{hoje.strftime('%Y-%m-%d')}.csv"

        s3 = boto3.client('s3',
                          aws_access_key_id=AWS_ACCESS_KEY_ID,
                          aws_secret_access_key=AWS_SECRET_ACCESS_KEY,
                          aws_session_token=AWS_SESSION_TOKEN,
                          region_name=AWS_REGION)

        s3.upload_file(nome_arquivo, BUCKET_NAME, nome_arquivo_destino)

        print("Arquivo enviado com sucesso!")

    except Exception as e:
        print(f"Erro: {e}")

if __name__ == "__main__":
    main()
