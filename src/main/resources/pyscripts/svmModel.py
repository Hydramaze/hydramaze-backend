import sys
import json
import getopt
import argumentParser as parser
#import data_set
from sklearn import datasets
from sklearn.cross_validation import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.svm import SVC

# global variables definition
kernel = None
verbose = None
C = None
cache_size = None
class_weight = None #ignored
coef0 = None
decision_function = None #ignored
degree = None
gamma = None
max_iter = None
probability = None
random_state = 42 #Hardcoded not useful to the end user
shrinking = None
tol = None

def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '', ['dataset=', 'test_size=','kernel=', 'verbose=', 'C=', 'cache_size=',
                                                 'coef0=', 'degree=', 'gamma=', 'max_iter=', 'probability=',
                                                 'shrinking=', 'tol='])
    except getopt.GetoptError:
        print 'Error when converting arguments.'
        sys.exit(2)
    for opt, arg in optlist:
        if opt == "--kernel":
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

        # print("option " + opt + " - argument " + arg)

def classifier():
    #load data_set
    iris = datasets.load_iris()
    #data_set features
    X = iris.data
    #data_set labels
    y = iris.target

    #split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = .5)

    #declare the classifier
    my_classifier = SVC(C=C, cache_size=cache_size, class_weight=None, coef0=coef0,
                        degree=degree, gamma=gamma, kernel=kernel, max_iter=max_iter,
                        probability=probability, random_state=random_state, shrinking=shrinking,
                        tol=tol, verbose=verbose)

    #fit(train) the classifier
    my_classifier.fit(X_train, y_train)

    #make predictions using the trained classifier
    predictions = my_classifier.predict(X_test)

    #measure the accuracy of the classifier
    accuracy = accuracy_score(y_test, predictions)

    #get the confusion matrix of about true and predicted values
    conf_matrix = confusion_matrix(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": accuracy, "confusion_matrix": conf_matrix.tolist()}},
                      sort_keys=True, separators=(',',':'))


try:
    getArguments(sys.argv[1:])
    print classifier()

except Exception as e:
    print json.dumps({"status": "error", "data": {"error": str(e)}}, sort_keys=True, separators=(',',':'))





