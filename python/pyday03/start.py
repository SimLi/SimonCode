"""
绘制五角星
"""
import turtle

#循环绘制
def loop_start():
    tur = turtle.Turtle()

    count = 1

    while count <= 5:
        tur.forward(50)
        tur.right(144)
        count += 1
    turtle.Screen().exitonclick()


if __name__ == '__main__':
    loop_start()
