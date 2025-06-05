from meteostat import Point, Daily
from datetime import datetime

start = datetime(2020, 1, 1)
end = datetime(2020, 12, 31)

location = Point(-23.55, -46.63)

data = Daily(location, start, end)
data = data.fetch()

print(data.head())

data.to_csv('/tmp/clima.csv')
