import turtle


def drow_tree(drow_length):
    if drow_length >=5 :

        #绘制左侧树
        turtle.forward(drow_length)
        turtle.right(20)
        drow_tree(drow_length - 10)


        #绘制右侧树
        turtle.left(40)
        drow_tree(drow_length - 10)

        #返回之前的树枝
        turtle.right(20)
        turtle.backward(drow_length)


if __name__ == '__main__':
    turtle.left(90)
    turtle.penup()
    turtle.bk(100)
    turtle.pendown()
    drow_tree(80)
    turtle.exitonclick()