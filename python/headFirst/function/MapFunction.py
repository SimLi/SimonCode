"""定义数字求平方"""
def square(x):
    return x*x

"""定义全体自然数"""
def  natural_number():
    n = 1
    while True:
        yield n
        n = n+1

"""全体自然数，求平方，通过map函数，返回平方的生成器"""
def primes():
    it = natural_number()
    while True:
        yield map(square, it)


def primes1():
    it = [1,2,3,4,5,6]
    print(list(map(square,it)))


def p2():
    it = [1,2,3,4,5,6,7]
    return list(map(square,it))


# for a in p2():
#     print(a)
# # print(list(primes(10)))
#
# primes1()
# print(primes(10))

"""限定范围的数字，求平方"""
for i in primes():
    n = next(i)
    print(n)
    if n >= 100:
        break