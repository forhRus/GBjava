from base.Figure import Figure
import math

class Circle(Figure):
    __name = "окружность"
    def __init__(self, radius):
        if (radius > 0):
            square = radius ** 2 * math.pi
            self.__length = 2 * math.pi * radius
            super().__init__(self.__name, square)
        else:
            print("Радиус меньше 0")


    def get_length(self):
        return self.__length

    def get_info(self):
        return f"{super().get_info()}, длина окр-ти: {self.__length}"
