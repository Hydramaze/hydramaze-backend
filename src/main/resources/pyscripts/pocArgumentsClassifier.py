import getopt
import sys

import argumentParser as parser

# global variables definition
dataset = None
test_size = None
kernel = None
verbose = None

def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '', ['dataset=', 'test_size=', 'kernel=', 'verbose='])
    except getopt.GetoptError:
        print 'Error when converting arguments.'
        sys.exit(2)

    for opt, arg in optlist:
        if opt == "--dataset":
            global dataset
            dataset = arg
        elif opt == "--test_size":
            global test_size
            test_size = arg
        elif opt == "--kernel":
            global kernel
            kernel = arg
        elif opt == "--verbose":
            global verbose
            verbose = arg

        print("option " + opt + " - argument " + arg)



def classifier(dataset_value, test_size_value, kernel_value, verbose_value):
    import json
    #import data_set
    from sklearn import datasets
    from sklearn.cross_validation import train_test_split
    from sklearn.metrics import accuracy_score
    from sklearn.svm import SVC
    from sklearn.metrics import confusion_matrix

    #load data_set
    if dataset_value == "iris":
        dataset = datasets.load_iris()
    elif dataset_value == "breast_cancer":
        dataset = datasets.load_breast_cancer()

    #data_set features
    X = dataset.data
    #data_set labels
    y = dataset.target

    #split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = test_size_value)

    #declare the classifier
    my_classifier = SVC(kernel=kernel_value,verbose=verbose_value)

    #fit(train) the classifier
    my_classifier.fit(X_train, y_train)

    #make predictions using the trained classifier
    predictions = my_classifier.predict(X_test)

    #measure the accuracy of the classifier
    accuracy = accuracy_score(y_test, predictions)

    #get the confusion matrix of about true and predicted values
    conf_matrix = confusion_matrix(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": accuracy, "confusion_matrix": conf_matrix.tolist()}}, sort_keys=True, separators=(',',':'))

# get arguments into its variables
getArguments(sys.argv[1:])

# variables validation
try:
    kernel = parser.str2kernel(kernel)
    verbose = parser.str2verbose(verbose)
    dataset = dataset
    test_size = parser.str2tol(test_size)
except Exception, e:
    print("[ERROR] Variables validation exception. Message: " + str(e))

# classifier call
try:
    print(classifier(dataset, test_size, kernel, verbose))
except Exception, e:
    print("[ERROR] Algorithm execution: Message: " + str(e))
