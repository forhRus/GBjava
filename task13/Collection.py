from base.Figure import Figure
class Collection:

    def __init__(self):
        self.__my_collection = []

    def add(self, figure: Figure):
        self.__my_collection.append(figure)

    def insert(self, index, figure: Figure):
        if(self.check_index(index)):
            self.__my_collection.insert(index, figure)

    def remove(self, index):
        if(self.check_index(index)):
            del self.__my_collection[index]

    def check_index(self, i):
        return  (i > 0 and i <= len(self.__my_collection))

    def get_list(self):
        new_list = self.__my_collection.copy()
        return new_list

