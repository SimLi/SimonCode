"""reduce把一个函数作用在一个序列[x1, x2, x3, ...]上，这个函数必须接收两个参数，reduce把结果继续和序列的下一个元素做
对应的函数运算"""
from functools import reduce
def sum(x, y):
    return x + y

def test_reduce():
    it = [1,2,3,4,5,6]
    return reduce(sum,it)

print(test_reduce())

"""首字母转大写，其余小写"""
def normalize(name):
    return name[:1].upper() + name[1:].lower()

"""列表推导实现，首字母大写"""
def normalizeList(list_name):
    return [names[:1].upper() + names[1:].lower() for names in list_name]


names=["Admin","SIMON","zCZAi"]
print(list(map(normalize,names)))

print(normalizeList(names))


def prod(_list):
    """
    列表乘积
    :param _list: 数字型
    :return: 返回列表乘积
    """
    return reduce(lambda x,y: x*y, _list)
print(prod([1,2,3,4,5]))




def str2float(str):
    """字符串转化为浮点数"""
    DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    # return reduce(lambda x, y: x * 10 + y, map(lambda s: DIGITS[s], str.replace(".", ""))) / (10 * len())
    return reduce(lambda x, y: x * 10 + y, map(lambda s: DIGITS[s], str.replace('.', ''))) / pow(10,len(str)-str.index('.')-1)
print(str2float("123.456"))




