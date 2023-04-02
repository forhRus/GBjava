
class Figure:
    def __init__(self, name, square):
        self.__name = name
        self.__square = square

    def get_name(self):
        return self.__name

    def get_squre(self):
        return self.__square

    def get_info(self):
        return f"фигура: {self.__name}, площадь: {self.__square}"

