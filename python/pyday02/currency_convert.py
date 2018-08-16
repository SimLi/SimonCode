"""
汇率转换，汇率是 6.77
"""


def convert_currency(exchange_rate, in_money):
    return in_money * exchange_rate

def input_money():
    # 美元兑换人民币
    USD_VS_CNY = 6.77
    exchange_rate = USD_VS_CNY
    currency_str_value = input('请输入转换的金额和货币代码：')
    unit = currency_str_value[-3:]
    if unit == 'CNY':
        exchange_rate = 1 / USD_VS_CNY
    elif unit == 'USD':
        exchange_rate = USD_VS_CNY
    else:
        exchange_rate = -1
    if exchange_rate != -1:
        in_money = eval(currency_str_value[:-3])
        # exchange_value = convert_currency(exchange_rate,in_money)

        # 定义lambda表达式
        convert_currency2 = lambda x : x * exchange_rate
        exchange_value = convert_currency2(in_money)

        print('转换后的金额是：', exchange_value)
    else:
        print('输入的货币单位不支持转换')


def main_q():
    # 美元兑换人民币
    USD_VS_CNY = 6.77

    exchange_rate = USD_VS_CNY
    currency_str_value = input('请输入转换的金额和货币代码：')

    while currency_str_value != 'Q':
        unit = currency_str_value[-3:]
        if unit == 'CNY':
            exchange_rate = 1 / USD_VS_CNY
        elif unit == 'USD':
            exchange_rate = USD_VS_CNY
        else:
            exchange_rate = -1
        if exchange_rate != -1:
            in_money = eval(currency_str_value[:-3])
            exchange_value = convert_currency(exchange_rate, in_money)
            print('转换后的金额是：', exchange_value)
        else:
            print('输入的货币单位不支持转换')
        print('********************************************')
        currency_str_value = input('请输入转换的金额和货币代码:')
    print('程序退出执行！')


if __name__ == '__main__':
    input_money()
    # main_q()