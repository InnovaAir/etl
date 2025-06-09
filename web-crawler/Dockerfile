FROM python:3.10-slim

RUN apt-get update && apt-get install -y cron

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY script.py .
COPY crontab.txt /etc/cron.d/my-cron

RUN chmod 0644 /etc/cron.d/my-cron && \
    crontab /etc/cron.d/my-cron

# Criar o log
RUN touch /var/log/cron.log

# Comando de entrada
CMD cron && tail -f /var/log/cron.log
