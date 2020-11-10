import numpy as np
import pandas as pd
import sys
import matplotlib.pyplot as plt
import seaborn as sea
import scipy
import sklearn

data = pd.read_csv('creditcard.csv')

print(data.columns)
print(data.shape)

data = data.sample(frac=0.2, random_state=1)

data.hist(figsize=(20, 20))
plt.show()

fraud = data[data['Class'] == 1]
valid = data[data['Class'] == 0]
outlier = len(fraud) / len(valid)
print("Fraud: {} cases".format(len(fraud)))
print("Valid: {} cases".format(len(valid)))
print(outlier)

corrMat = data.corr()
fig1 = plt.figure(figsize=(12, 9))
sea.heatmap(corrMat, vmax=0.8, square=True)
# plt.show()

# Organize data
columns = data.columns.tolist()
ex_class_columns = [col for col in columns if col not in ['Class']]

tar = 'Class'
X = data[ex_class_columns]
Y = data[tar]

# algos
from sklearn.metrics import classification_report, accuracy_score
from sklearn.ensemble import IsolationForest
from sklearn.neighbors import LocalOutlierFactor
rand_state = 1
classifier = {
    'Isolation Forest': IsolationForest(max_samples=len(X), contamination=outlier, random_state=rand_state),
    'Local Outlier Factor': LocalOutlierFactor(n_neighbors=20, contamination=outlier)
}

# fit model
for i, (clf_name, clf) in enumerate(classifier.items()):
    if clf_name == 'Local Outlier Factor':
        y_pred = clf.fit_predict(X)
        score_pred = clf.negative_outlier_factor_
    else:
        clf.fit(X)
        y_pred = clf.predict(X)
        score_pred = clf.decision_function(X)

    y_pred[y_pred == 1] = 0
    y_pred[y_pred == -1] = 1

    n_errors = (y_pred != Y).sum()

    print('{}: {}'.format(clf_name, n_errors))
    print(accuracy_score(Y, y_pred))
    print(classification_report(Y, y_pred))

