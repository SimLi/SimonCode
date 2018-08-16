"""
密码判断工具
"""


class PassWordTools:

    def __init__(self,password):
        self.password = password
        self.pass_level = 0

    # 判断是够包含字符
    def password_is_str(self):
        for str in self.password:
            if str.isalpha():
                return True
        return False

    # 判断是否包含数字
    def password_is_number(self):
        for str in self.password:
            if str.isalnum():
                return True
        return False

    # 获得字符的长度
    def password_len(self):
        print('密码是：',self.password)
        return len(self.password)


class PasswordFileTools:
    def __init__(self,filePath):
        self.file_path = filePath

    def password_write(self,line):
        f = open(self.file_path, 'a')
        f.write(line)
        f.close()

    def password_readlines(self):
        f = open(self.file_path, 'r')
        lines = f.readlines()
        f.close()
        return lines



def main():

    file_tools = PasswordFileTools('password.txt')
    try_times = 5
    while try_times > 0:
        input_password_str = input('请输入密码：')
        passwordtools = PassWordTools(input_password_str)
        file_tools.password_write('密码是：{}\n'.format(input_password_str))
        if passwordtools.password_len() < 8:
            print('密码长度不能小于8')
            try_times -= 1
            continue
        if not passwordtools.password_is_number():
            print('密码必须包含数字')
            try_times -= 1
            continue
        if not passwordtools.password_is_str():
            print('密码必须包含字符')
            try_times -= 1
            continue
        print('恭喜你，密码符合要求',end='\n')
        break

    # 读取输入的密码
    lines = file_tools.password_readlines()
    for line in lines:
        print(line)


if __name__ == '__main__':
    main()