"""python中，一切皆对象，函数，class...."""
from functools import wraps

from django.http import request


def hi(name = "卡西"):
    return "Hi " + name
print(hi())


"""
可以把函数赋值给一个变量，此时，变量指向的是这个函数的地址
<function hi at 0x000001E2528F2EA0>
Hi 卡西"""
geet = hi
print(geet)
print(geet())


"""函数也是一个对象，那么在函数中，同样也可以定义函数"""
def hi(name="simon"):
    print("这是函数的输出，在hi()内部")
    def greet():
        return "这是函数hi（）内部的函数greet的返回"
    def welcome():
        print("welcome调用greet函数" + greet())
        return "这是在welcome内部的返回"
    print(greet())
    print(welcome())
    print("这是hi（）函数的最后")
hi()


"""函数中的返回值，也可以是函数"""
def returnHi(name = "Simon"):
    def simon():
        return "这是simon函数"
    def kaxi():
        return "这是卡西函数"
    if name == "Simon":
        """返回的是函数引用，这种返回方式，并不会立即执行对应的函数，只有在调用
        明确调用改返回值的时候，函数才会执行
        """
        return simon
    else:
        return kaxi
a=returnHi("kaxi")
"""
<function returnHi.<locals>.kaxi at 0x000001C39A5DF598>
这是卡西函数
"""
print(a)
print(a())


"""函数也可以做为一个参数传递给另外一个函数"""
def funcParams(func):
    print("这里的func应该是个函数")
    print(func())
print("----------------函数也可以做为一个参数传递给另外一个函数------------")
# print(funcParams(hi())) 注意，函数的传递，不能这样传递函数
print(funcParams(hi))


print("-----------------------------下面是装饰器-------------------------")


def my_new_decorator(a_func):
    def warpTheFunction():
        print("在执行a_func函数之前，做一些事情")
        a_func()
        print("在执行a_func函数之后，做一些事情")
    return warpTheFunction
def a_func():
    print("函数a_func做一些事情")

"""单独调用a_func"""
a_func()

print("------------通过定义的装饰器执行a_func------------")
"""通过定义的装饰器执行a_func"""
a_func_decorator = my_new_decorator(a_func)
a_func_decorator()

print("----------使用@符号，调用定义的装饰器-------------")
"""使用@符号，调用定义的装饰器"""


@my_new_decorator
def a_func_at():
    print("这是通过@符号，添加的装饰器")

print("调用@符号添加的装饰器")
a_func_at()


print("查看被@符号修饰的a_func_at函数名称")
print("a_func_at的名称是：" + a_func_at.__name__)


"""装饰器的wraps功能"""


def a_new_decorator_wraps(f):
    @wraps(f)
    def wrapTheFunction():
        print("这是装饰器的函数")
        f()
        print("函数f执行完毕")
    return wrapTheFunction


@a_new_decorator_wraps
def a_function_requiring_decoration():
    """Hey yo! Decorate me!"""
    print("I am the function which needs some decoration to remove my foul smell")

print("-----------------装饰器内部，使用了wraps函数---------")
a_function_requiring_decoration()
print(a_function_requiring_decoration.__name__)


"""装饰器的应用"""
"""权限验证或者授权"""
# def requires_auth(f):
#     @wraps(f)
#     def decorated(*args, **kwargs):
#         auth = request.authorization
#         if not auth or not check_auth(auth.username, auth.password):
#             authenticate()
#             return f(*args, **kwargs)
#         return decorated

"""日志"""
def logit(func):
    @wraps(func)
    def with_logging(*args, **kargs):
        print(func.__name__ + " 添加的装饰器执行了")
        return func(*args, **kargs)
    return with_logging

@logit
def addition_func():
    print("测试日志的装饰器")

addition_func()



"""带参数的装饰器"""


print("---------------------带参数的log--------------------")
def logit_params(file="file_log.log"):
    def logging_decorator(func):
        @wraps(func)
        def wrapped_func(*args, **kargs):
            log_string = func.__name__ + " 函数名称是"
            print(log_string)
            for name in args:
                print("装饰器内部的参数是：" + name)
            with open(file, 'a', encoding="utf-8") as open_log:
                open_log.write(log_string + "\n")
            return func(*args, **kargs)
        return wrapped_func
    return logging_decorator


"""注意：此处的装饰器要用函数的形式"""
@logit_params()
def mylog(name):
    print("mylog name = " + name)


mylog("卡西")


