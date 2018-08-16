"""
52周存钱计划
"""
import math
def main():
    """
    存钱计划
    """
    week_money = 10     #每周存入的钱数
    i = 1               #记录周数
    increase_money = 10 #每周递增的钱数
    saving = 0          #存的钱数
    sav_list = []
    while i <= 52:
        sav_list.append(week_money)
        i += 1
        week_money += increase_money
    sav_all = math.fsum(sav_list)
    print('存入了{}'.format(sav_all))


def money_for(week_num):
    week_list = range(1,week_num+1)
    week_money = 10  # 每周存入的钱数
    i = 1  # 记录周数
    increase_money = 10  # 每周递增的钱数
    sav_list = []
    for i in week_list:
        sav_list.append(week_money)
        print('第{}周,存入了{}元，账户总合计{}'.format(i,week_money,math.fsum(sav_list)))
        week_money += increase_money

if __name__ == '__main__':
    # main()
    money_for(52)