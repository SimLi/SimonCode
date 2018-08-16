foo = ['hi']
bar = foo
bar += ['卡西']
"""此处会出现一个神奇的现象，我们预期的应该是在数组里面，添加上 “卡西” 这个名字，
如果使用  bar += '卡西' 这种形式，数组里面其实是把“卡西”作为连个元素进行存放的，
由此可以推断出，数组的 += 是对符号后面的对象进行迭代进行合并的，所以，+=后面跟的
如果是不可迭代对象，则应该会报错。eg： bar += '卡西' 会报出下面异常
    bar += 12
TypeError: 'int' object is not iterable
 """
bar += '卡西'


"""输出结果为 ['hi', '卡西', '卡', '西'] 由此可知，数组类型的赋值和引用，是
地址传递"""
print(bar)


f = 1
b = f
b += 2
"""输出结果b ==  3 
    f ==  1，由此可知，数组类型的赋值操作，是值传递"""
print("b == ", b)
print("f == ", f)


"""函数的默认值操作"""

print("----------------------函数的默认值------------------")
def add_default(num, target=[]):
    target.append(num)
    return target

t1 = add_default(44)
print(t1) # [44]

t2 = add_default(55)
print(t2) # [44, 55]
"""输出结果可以看到，函数的默认值，在整个运行期间，默认
参数只会运算⼀次， ⽽不是每次被调⽤时都会重新运算，如果想要实现每次调用，都是新生成一个对象，
应该进行如下定义操作"""


def add_default_new(num, target=None):
    if target is None:
        target = []
    target.append(num)
    return target

t1 = add_default_new(44)
print(t1) # [44]

t2 = add_default_new(55)
print(t2) # [55]

