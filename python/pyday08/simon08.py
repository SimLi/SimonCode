"""
作者：Simon
随机数
"""


import random
import matplotlib.pyplot as plt

def roll_dice():
    roll = random.randint(1, 6)
    return roll

def main():
    dice_times = 10000
    #生成长度为6 内容为0的列表
    dice_list = [0] * 6
    print(dice_list)
    for i in range(dice_times):
        roll = roll_dice()
        # print(roll)
        for j in range(1, 7):
            if j == roll:
                dice_list[j-1] += 1

    print(dice_list, end='\n')

    #enumerate转化列表
    for i, x in enumerate(dice_list):
        print('点数{}，出现了{}次，频率是：{}'.format(i + 1 ,x, x/dice_times))

def roll_double():
    dice_times = 100000
    result_list = range(0, 11)
    roll_list = range(2, 13)
    roll_dict = dict(zip(roll_list,result_list))
    for i in range(dice_times):
        roll1 = roll_dice() + roll_dice()
        roll_dict[roll1] += 1

    for key ,value in roll_dict.items():
        print('点数{}，出现了{}次，频率是：{}'.format(key ,value, value/dice_times))


def roll_double_map():
    dice_times = 1000
    result_list = range(0, 11)
    roll_list = range(2, 13)
    roll_dict = dict(zip(roll_list, result_list))
    roll_result_list = []
    for i in range(dice_times):
        roll1 = roll_dice() + roll_dice()
        roll_dict[roll1] += 1
        roll_result_list.append(roll1)

    for key, value in roll_dict.items():
        print('点数{}，出现了{}次，频率是：{}'.format(key, value, value / dice_times))

    #数据可视化
    plt.scatter(range(1,dice_times + 1), roll_result_list)
    plt.show()


if __name__ == '__main__':
    # main()
    # roll_double()
    roll_double_map()