import numpy as np
from matplotlib import pyplot as plt
from __future__ import print_function
# from matplotlib.font_manager import FontProperties

# load txt/csv file
def loadFile(name, split, dataType):
    return np.loadtxt(name, delimiter=split, dtype=dataType)

# load npy file
def load_npy(name):
    return np.load(name)

# normalize features
def normalizeFeatures(X):
    X_norm = np.array(X)
    mu = np.zeros((1, X.shape[1]))
    sigma = np.zeros((1, X.shape[1]))

    mu = np.mean(X_norm, 0)
    sigma = np.std(X_norm, 0)

    for i in range(X.shape[1]):
        X_norm[:, i] = (X_norm[:, i] - mu[i]/sigma[i])

    return X_norm, mu, sigma

# cost function
def computeCost(X, y, theta):
    m = len(y)
    J = 0
    J = (np.transpose(X * theta - y) * (X * theta - y) / (2 * m))
    return J

# gradient decent
def gradientDecent(X, y, theta, alpha, nums):
    m = len(y)
    n = len(theta)

    temp_theta = np.matrix(np.zeros(n, nums))

    temp_cost = np.zeros((n, nums))

    for i in range(nums):
        