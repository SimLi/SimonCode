def many_return():
    name = "Simon"
    love = "Love"
    she = "卡西"
    return name, love, she

result = many_return()
print(type(result))
for str in result:
    print(str, end=" ")
