# encoding: utf-8  

""" 
@version: v1.0 
@author: Simon 
@software: PyCharm 
@file: SturentClass.py 
@time: 2017/12/23 20:37 
"""


class SturentClass(object):
    def __init__(self,name):
        SturentClass.count = SturentClass.count + 1
        self.name = name
        self.count = 0
        pass
    name,adree = "",""
    count=0

    def print_sturent_count(self):
        print(" 当前的学生个数是：%d" , SturentClass.count,SturentClass.name)

    def print_self_count(self):
        print(" 学生实例中的count数是： %d " , self.count,self.name)

student1 = SturentClass("Simon")
student1.print_self_count()
student1.print_sturent_count()

student2 = SturentClass("昭昭")
student2.print_self_count()
student2.print_sturent_count()




