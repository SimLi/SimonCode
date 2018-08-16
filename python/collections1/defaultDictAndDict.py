from collections import defaultdict
colours = (
    ('a', 'Yello1'),
    ('d', 'Yello2'),
    ('c', 'Yello3'),
    ('d', 'Yello4'),
    ('a', 'Yello5'),
    ('c', 'Yello6'),
    ('a', 'Yello7'),
)

favourite_colours = defaultdict(list)
favourite_dict_colours = dict()

for name, value in colours:
    favourite_colours[name].append(value)
    print(name)

for name, value in colours:
    """字典的Key值如果不存在，直接调用的时候，会报出KeyError异常"""
    # print(favourite_dict_colours[name])
    favourite_dict_colours[name].append(value)

print(favourite_colours)