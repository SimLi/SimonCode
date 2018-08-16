"""
52周存钱计划
"""

def main():
    """
    存钱计划
    """
    week_money = 10     #每周存入的钱数
    i = 1               #记录周数
    increase_money = 10 #每周递增的钱数
    saving = 0          #存的钱数

    while i <= 52:
        saving += week_money
        print('第{}周，存入了{}元， 账户金额是{}'.format(i,week_money,saving))
        i += 1
        week_money += increase_money

if __name__ == '__main__':
    main()