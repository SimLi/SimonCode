"""
判断日期是一年中的第几天
"""
from datetime import datetime

def is_leap_year(year):
    if ((year % 400) == 0 )  or ( year % 4 == 0 and year % 100  != 0 ):
        return True
    else:
        return False

def main():
    input_day_str = input('输入日期（yyyy/mm/dd）:')
    input_date = datetime.strptime(input_day_str,'%Y/%m/%d')
    print(input_date)

    year = input_date.year
    month = input_date.month
    days = input_date.day

    days_in_month_list = [31,28,31,30,31,30,31,31,30,31,30,31]

    if is_leap_year(year):
        print('这是闰年')
        days_in_month_list[1] = 29

    print('当前日期{}是第{}天'.format(input_day_str,sum(days_in_month_list[:month-1]) + days))

    # 计算当前日的天数



if __name__ == '__main__':
    main()