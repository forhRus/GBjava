from base.Figure import Figure
from interface.Perimeter import Perimeter

class Polygon(Figure, Perimeter):

    def __init__(self, name, square, perimeter):
        super().__init__(name, square)
        self.__perimeter = perimeter

    def get_perimeter(self):
        return self.__perimeter

    def get_info(self):
        return f"{super().get_info()}, периметер: {self.__perimeter}"