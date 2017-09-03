import sys
import argumentParser as parser
import traceback


def classifier(kernel_value, verbose_value):
    import json
    #import data_set
    from sklearn import datasets
    from sklearn.cross_validation import train_test_split
    from sklearn.metrics import accuracy_score
    from sklearn.svm import SVC

    #load data_set
    iris = datasets.load_iris()
    #data_set features
    X = iris.data
    #data_set labels
    y = iris.target

    #split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = .5)

    #declare the classifier
    my_classifier = SVC(kernel=kernel_value,verbose=verbose_value)

    #fit(train) the classifier
    my_classifier.fit(X_train, y_train)

    #make predictions using the trained classifier
    predictions = my_classifier.predict(X_test)

    #measure the accuracy of the classifier
    accuracy = accuracy_score(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"accuracy": accuracy, "status": "success"}, sort_keys=True, separators=(',',':'))


try:
    kernel = parser.str2kernel(sys.argv[1])
    verbose = parser.str2verbose(sys.argv[2])
    print(classifier(kernel, verbose))
except Exception as e:
    traceback.print_exc()





