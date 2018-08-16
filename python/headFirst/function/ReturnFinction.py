"function return "

def lazy_sum(*args) :
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum

f1 = lazy_sum(1,2,3,4)
f2 = lazy_sum(2,3,4,5)
print(f1)
print(f2)
print(f1())
print(f2())


"""函数返回函数的时候，函数内部定义的局部变量会被返回的函数共享，示例如下"""
def count():
    fs = []
    for i in range(1, 4):
        def f():
             return i*i
        fs.append(f)
    return fs
"""函数count由于是惰性求值，在调用count的时候，并没有马上执行求值的动作，但是count内部的函数 f 引用了 count函数的变量 i
来进行计算，并且列表fs中存储的是函数f，所以当for语句执行完成，返回ds以后，i的值已经变成了3，此时的函数 f 里面的语句 i*i = 3*3 """
f3 = count()
print(f3[0]()) #9
print(f3[1]()) #9
print(f3[2]()) #9

