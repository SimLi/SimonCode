# encoding: utf-8

"""
@version: v1.0
@author: Simon
@software: PyCharm
@file: Student.py
@time: 2017/12/23 16:15
"""

class Student():
    def __init__(self,name,score):
        self.name = name
        self.score = score
    def toString(self):
        print(" %s %s" % (self.name,self.score))
stu = Student("Simon","100")
stu.toString()