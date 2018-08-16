"""
    Simon
    计算人体代谢率（BMR）
"""

def main():
    """
        计算人体BMR
    """
    y_or_n = input('是否退出程序（y/n）')
    while y_or_n != 'y':
        person = input('输入性别 年龄 身高 体重：')
        list_person = person.split(' ')
        bmr = -1
        try:

            #性别
            gender = list_person[0]

            #年龄
            age = int(list_person[1])

            # 身高
            height=float(list_person[2])

            #体重
            weight = float(list_person[3])

            if gender == '男':
                bmr = (13.7 * weight ) + ( 5.0 * height) - (6.8 * age) + 66
            elif gender == '女':
                bmr = (9.6 * weight ) + ( 1.8 * height) - (4.7 * age) + 665
            else:
                print('不支持性别类型')

            if bmr != -1:
                print('你的性别是{}, 年龄是{},身高是：{}, 体重是：{}'.format(gender,age,height,weight))
                print('你的基础代谢率是：{}'.format(bmr))
        except ValueError:
            print('输入内容有误，除性别外，只能输入数字类型')
        except:
            print('输入内容有误!')

        print('------------------华丽的分割线-------------')
        y_or_n = input('是否退出程序（y/n）')


if __name__ == '__main__':
    main()