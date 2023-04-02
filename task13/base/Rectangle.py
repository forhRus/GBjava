from base.Polygon import Polygon


class Rectangle(Polygon):
    __name = "пямоугольник"
    def __init__(self, sideA, sideB):
        p = (sideA + sideB) * 2
        s = sideA * sideB
        super().__init__(self.__name, s, p)