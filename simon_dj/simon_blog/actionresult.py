class actionresult(object):
    def __init__(self,code = '200',data=[],msg='scuess',err_num=0):
        self.code = code
        self.data = data
        self.msg = msg
        self.err_num = err_num