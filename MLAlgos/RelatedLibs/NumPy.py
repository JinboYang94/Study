import numpy as np

np.random.seed(0)

a = np.random.randint(10, size=6)   # one-dimensional array
b = np.random.randint(10, size=(3, 4))  # two-dimensional array
c = np.random.randint(10, size=(3, 4, 5))   # three-dimensional array

# array attributes:
# c.ndim => 3, the number of dimensions
# c.shape => (3, 4, 5), the size of each dimension
# c.size => 60, the total size of the array
# c.dtype => int32, data type of the array
# c.itemsize => 8, size in bytes of each array element
# c.nbytes => 480, total size in bytes of the array

# array slicing:
# x[start:stop:step]
# when step negative, swap start with stop, i.e, x[::-1] is reversed x

# array concatenation:
# grid = np.array([[1, 2, 3],
#                  [4, 5, 6]])
# np.concatenate(grid, grid) => [[1, 2, 3],
#                                [4, 5, 6],
#                                [1, 2, 3],
#                                [4, 5, 6]]

