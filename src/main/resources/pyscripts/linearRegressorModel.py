import sys
import json
import getopt
import argumentParser as parser
#import data_set
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.metrics import r2_score
from sklearn.linear_model import LinearRegression

# global variables definition
fit_intercept = None
normalize = None
copy_X = None
n_jobs = None

dataset = datasets.load_boston()

def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '', ['dataset=', 'test_size=','fit_intercept=', 'normalize=', 'copy_X=',
                                                 'n_jobs='])
    except getopt.GetoptError:
        print 'Error when converting arguments.'
        sys.exit(2)
    for opt, arg in optlist:
        if opt == "--dataset":
            global dataset
            dataset = arg
        elif opt == "--test_size":
            global test_size
            test_size = parser.str2tol(arg)
        elif opt == "--fit_intercept":
            global fit_intercept
            fit_intercept = parser.str2fit_intercept(arg)
        elif opt == "--normalize":
            global normalize
            normalize = parser.str2normalize(arg)
        elif opt == "--copy_X":
            global copy_X
            copy_X = parser.str2copy_X(arg)
        elif opt == "--n_jobs":
            global n_jobs
            n_jobs = parser.str2n_jobs(arg)


def getDataset():
    global dataset
    #load data_set
    if dataset == "diabetes":
        loaded_dataset = datasets.load_diabetes()
    elif dataset == "boston":
        loaded_dataset = datasets.load_boston()
    else:
        raise Exception('Dataset is not a valid one. Try diabetes or boston.')

    return loaded_dataset

def regressor(loaded_dataset):
    #data_set features
    X = loaded_dataset.data
    #data_set labels
    y = loaded_dataset.target

    #split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = 0.3)

    #declare the regressor
    my_regressor = LinearRegression(fit_intercept = fit_intercept, normalize = normalize, copy_X=copy_X,
                                    n_jobs = n_jobs)

    #fit(train) the regressor
    my_regressor.fit(X_train, y_train)

    #make predictions using the trained regressor
    predictions = my_regressor.predict(X_test)

    #measure the r2_score of the regressor
    r2_score_value = r2_score(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": r2_score_value}}, sort_keys=True, separators=(',',':'))

try:
    getArguments(sys.argv[1:])
    print regressor(getDataset())
except Exception as e:
    print json.dumps({"status": "error", "data": {"error": str(e)}}, sort_keys=True, separators=(',',':'))