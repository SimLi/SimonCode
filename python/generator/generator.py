"""python生成器理解： 生成器在调用的时候，会返回一个可迭代对象，可以对该对象进行迭代，通过yield来获取生成器
中的值，例如，实现斐波那契数列的生成器写法"""


def fibon(n):
    a = b = 2
    print("生长器的for循环之前执行------>a=={0} and b=={1}".format(a, b))
    for i in range(n):
        print("生长器的for循环之后，yield之前执行------>a=={0} and b=={1}".format(a, b))
        yield a
        a, b = b, a+b
        print("生成器内部的数值是： a == {0}, b=={1}".format(a, b))


for x in fibon(5):
    print("执行生成器，返回的结果是：x=={0}".format(x))
    print("第二次输出======")