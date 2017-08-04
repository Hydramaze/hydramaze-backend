#import data_set

import json

from sklearn import datasets
iris = datasets.load_iris()
X = iris.data
y = iris.target
from sklearn.cross_validation import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = .5)

from sklearn.svm import SVC
my_classifier = SVC()
my_classifier.fit(X_train, y_train)
predictions = my_classifier.predict(X_test)

from sklearn.metrics import accuracy_score

print "teste"
print accuracy_score(y_test, predictions)
print "Teste realizado com sucesso!"
print json.dumps({"data": X.tolist(), "target": y.tolist(), "status": "success"}, sort_keys=True, separators=(',',':'))