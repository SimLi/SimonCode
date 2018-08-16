def test_var_args(*args):
    for arg in args:
        print("*args have arg is :" , arg)


def test_var_kwargs(**kwargs):
    for key, value in kwargs.items():
        print("{0} == {1}".format(key, value))


"""第一种传参方式, 输出的结果为 "*args have arg is : ['我', '写', 'python']"  """
list = ["我", "写", "python"]
test_var_args(*list)


"""第二种传参方式，输出结果为：
*args have arg is : 我
*args have arg is : 写
*args have arg is : python"""
test_var_args("我", "写", "python")


"""字典方式传入参数，需要在参数前面添加**"""
test_dict = {"key1": "我", "key2": "写", "key3": "python"}
test_var_kwargs(**test_dict)

print("--------------------------------------------------------")
print("调用函数，传入字典")
test_var_kwargs(**{"key1": "我", "key2": "写", "key3": "python"})
