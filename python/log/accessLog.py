log = open("D:\Project\LongFor\log\localhost_access_log.2018-08-06.txt")
ipset = set()
for index in range(168669):
    line = log.readline()
    logArray = line.split(" ")

    # print(logArray)
    if len(logArray) > 3 & logArray[4].find("PlanService"):
        ipset.add(logArray[0])
    # print(logArray)

# { 2018-08-07 -- '192.168.10.151' 计划 , '192.168.48.178' 计划, '192.168.10.37', 计划
#  '192.168.33.175', '192.168.10.248', '192.168.10.150' 计划 , '192.168.10.135'}


print(ipset)


