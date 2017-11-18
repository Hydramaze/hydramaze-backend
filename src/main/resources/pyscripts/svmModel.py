import sys
import json
import getopt
import argumentParser as parser
# import data_set
from sklearn import datasets
from sklearn.cross_validation import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.svm import SVC

# global variables definition
dataset = None
test_size = None
kernel = None
verbose = None
C = None
cache_size = None
class_weight = None  # ignored
coef0 = None
decision_function = None  # ignored
degree = None
gamma = None
max_iter = None
probability = None
shrinking = None
tol = None


def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '', ['dataset=', 'test_size=', 'kernel=', 'verbose=', 'C=', 'cache_size=',
                                                 'coef0=', 'degree=', 'gamma=', 'max_iter=', 'probability=',
                                                 'shrinking=', 'tol='])
    except getopt.GetoptError:
        print 'Error when converting arguments.'
        sys.exit(2)
    for opt, arg in optlist:
        if opt == "--dataset":
            global dataset
            dataset = arg
        elif opt == "--test_size":
            global test_size
            test_size = parser.str2test_size(arg)
        elif opt == "--kernel":
            global kernel
            kernel = parser.str2kernel(arg)
        elif opt == "--verbose":
            global verbose
            verbose = parser.str2verbose(arg)
        elif opt == "--C":
            global C
            C = parser.str2C(arg)
        elif opt == "--cache_size":
            global cache_size
            cache_size = parser.str2cache_size(arg)
        elif opt == "--coef0":
            global coef0
            coef0 = parser.str2coef0(arg)
        elif opt == "--degree":
            global degree
            degree = parser.str2degree(arg)
        elif opt == "--gamma":
            global gamma
            gamma = parser.str2gamma(arg)
        elif opt == "--max_iter":
            global max_iter
            max_iter = parser.str2max_iter(arg)
        elif opt == "--probability":
            global probability
            probability = parser.str2probability(arg)
        elif opt == "--shrinking":
            global shrinking
            shrinking = parser.str2shrinking(arg)
        elif opt == "--tol":
            global tol
            tol = parser.str2tol(arg)


def getDataset():
    global dataset
    # load data_set
    if dataset == "iris":
        loaded_dataset = datasets.load_iris()
    elif dataset == "breast_cancer":
        loaded_dataset = datasets.load_breast_cancer()
    elif dataset == "digits":
        loaded_dataset = datasets.load_digits()
    else:
        raise Exception('Dataset is not a valid one. Try iris, breast_cancer or digits.')

    return loaded_dataset


def classifier(loaded_dataset):
    # data_set features
    X = loaded_dataset.data
    # data_set labels
    y = loaded_dataset.target
    # get class names from dataset
    class_names = loaded_dataset.target_names

    # split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=1-test_size)

    # declare the classifier
    my_classifier = SVC(C=C, cache_size=cache_size, class_weight=None, coef0=coef0,
                        degree=degree, gamma=gamma, kernel=kernel, max_iter=max_iter,
                        probability=probability, shrinking=shrinking, tol=tol,
                        verbose=verbose)

    # fit(train) the classifier
    my_classifier.fit(X_train, y_train)

    # make predictions using the trained classifier
    predictions = my_classifier.predict(X_test)

    # measure the accuracy of the classifier
    accuracy = accuracy_score(y_test, predictions)

    # get the confusion matrix of about true and predicted values
    conf_matrix = confusion_matrix(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": accuracy, "confusion-matrix": {"class_names": class_names.tolist(),"matrix": conf_matrix.tolist()}}}, sort_keys=True, separators=(',',':'))


try:
    getArguments(sys.argv[1:])
    print classifier(getDataset())

except Exception as e:
    print json.dumps({"status": "error", "data": {"error": str(e)}}, sort_keys=True, separators=(',', ':'))
