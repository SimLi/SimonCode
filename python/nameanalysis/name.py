import pandas as pd
import numpy as np
from collections1 import Counter

data = pd.read_csv('data/NationalNames.csv')
#     Id       Name  Year Gender  Count
# 0   1       Mary  1880      F   7065
print(data.head())
print('aa')
data.info()

# 字典存放姓名和姓名数量的和  Name和Count和
name_dict = dict()
for index,row in data.iterrows():
    if row['Name'] not in name_dict:
        name_dict[row['Name']] = row['Count']
    else:
        name_dict[row['Name']] += row['Count']
name = 'Mary'
print('%s -> %i' %(name,name_dict.get(name)))

print('最流行的名称前10排行榜')
top_10 = Counter(name_dict).most_common(10)
for pair in top_10:
    print('姓名： %s --> 数量：%i' %(pair[0],pair[1]))

