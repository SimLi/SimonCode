movies = ["飞屋环游记", "梵高传", "西游记"]
print(movies)
print(movies[0])
print(movies[1])
print(movies[2])

"""列表长度len(Array_Object)"""
print(len(movies))

"""列表添加一个元素，在尾部"""
movies.append("昭昭")
print(len(movies))
print(movies[3])

"""列表头部，出栈一个元素，并删除该元素"""
print(movies.pop())
print(movies)

""" 向列表中，添加一个列表"""
print("-- 向列表中，添加一个列表--")
movies.extend(["肖申克的救赎", "当幸福来敲门"])
print(movies)

"""列表中，删除一个指定元素"""
print(movies.remove("梵高传"))
print(movies)

print("--------列表中，插入一个元素，inster无返回值------------")
print(movies)
print(movies.insert(2, "白眉大侠"))
print(movies)
movies.insert(2, ["包青天", "西游记"])
print(movies)

print("---for循环遍历列表------")
for each_item in movies:
    print(each_item)
print("---for循环结束-----------")

print("-----while循环-----------")
count = 0
while count < len(movies):
    print(movies[count])
    count = count + 1
print("--while循环结束------------")

"""插入电影其他信息"""
movies.insert(1, 1975)
movies.insert(3, 1989)
print(movies)

print("---测试instance BIF函数-----")
for each_item in movies:
    if isinstance(each_item, list):
        for item in each_item:
            print(item)
    else:
        print(each_item)
print("---- instance BIF执行结束------")

print("-----添加一个函数，进行迭代列表数据----")


def print_lol(the_list):
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item)
        else:
            print(each_item)


print("----调用函数 print_lol--------------")
print_lol(movies)
print("__________调用结束------------")
