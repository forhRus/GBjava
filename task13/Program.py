from base.Circle import Circle
from base.Quadrate import Quadrate
from base.Rectangle import Rectangle
from Collection import Collection

f1 = Circle(3)
print(f1.get_info())

f2 = Quadrate(3)
print(f2.get_info())

f3 = Rectangle(2, 5)
print(f3.get_info())

col = Collection()
col.add(f1)
col.add(f2)
col.add(f3)
col.remove(1)
l = col.get_list()

