from base.Polygon import Polygon


class Quadrate(Polygon):
    __name = "квадрат"
    def __init__(self, side: float):
        p = side * 4
        s = side ** 2
        super().__init__(self.__name, s, p)

