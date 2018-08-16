class MyClassNoSlots(object):
    def __init__(self, name, identifier):
        self.name = name
        self.identifier = identifier
        self.personInfo = name + "-->" + identifier

    def __str__(self):
        print("class info== ", self.name,self.personInfo)

class MyClassSolts(object):
    __slots__ = ['name', 'identifier']

    def __init__(self, name, identifier):
        self.name = name
        self.identifier = identifier
        # self.personInfo = name + "-->" + identifier

nosolts = MyClassNoSlots("Simon", "abcd1234")

solts = MyClassSolts("卡西", "0804209")
# solts.personInfo = solts.name + "---" + solts.identifier
nosolts.add = nosolts.personInfo


print(nosolts)
print(solts)