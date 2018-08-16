# encoding: utf-8

"""打开文件,默认是读权限"""
from io import UnsupportedOperation

file1 = open("test.txt",encoding="utf-8")
print(file1)
"""read方法读取所有行"""
print(file1.read())
print("__________读取不存在的行数---------")
print(file1.readline(10))
print("------------")
try:
    file1.write("这里写入数据会出错，因为是读模式打开的文件")
except UnsupportedOperation as e :
    print(e)
    print(" 异常产生 " )
finally:
    file1.close()
# file1.close()

# 写形式打开文件 w，w模式的写入，在打开文件以后，就会清空文档里面的信息
file2 = open("test.txt",mode="w",encoding="utf-8")
# 这里读取文件，打开模式是w模式，w形式的写，会清空打开的文件，重新写入新的内容
# print(file2.read())
file2.write("这是python的w模式写入的文字\n")
file2.write("这是python的w模式写入的文字，第二行")
file2.close()

# a 模式打开文件
file_a = open("test.txt",mode="a",encoding="utf-8")

# 这里读取文件，打开模式是a模式，a形式的写，会在原来的文件后面，追加内容
# print(file_a.read())
file_a.write("原来的内容后面，追加的内容\" a\"模式的写入")
file_a.write("\n换行追加，追加的内容\" a\"模式的写入")
file_a.close()
print("-------------------a模式打开关闭--------------")

# + 模式打开，更新文件，读写形式，根据传入的参数的形式，可以推测出 + 模式的用法有 r+,w+,a+,测试如下
# r+ 模式打开的文档，写入的时候，是按照 a模式写入的
file_u = open("test.txt",mode="r+",encoding="utf-8")
print(file_u.read())
print(file_u.write("+++"))
print("+模式写入以后的执行")
file_u.flush()
print(file_u.read())
file_u.close()


with open("test.txt",mode="r",encoding="utf-8") as wfr:
    print("r+模式打开文档以后")
    print(wfr.read())

# w+ 形式
with open("test.txt",mode="w+",encoding="utf-8") as wf1:
    print(wf1.read())
    print(wf1.write("w模式，清空内容，重新写入"))

with open("test.txt",mode="r",encoding="utf-8") as wf:
    print(wf.read())

with open("test.txt",mode="a+",encoding="utf-8") as wfa:
    print("--------------------a+模式的打开文档---------------")
    print(wfa.read())
    wfa.writelines("追加一行数据")
    wfa.writelines("追加第二行数据")

with open("test.txt",mode="r",encoding="utf-8") as wfr:
    print(wfr.read())

