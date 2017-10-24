import sys
import json
import getopt
import argumentParser as parser
# import data_set
from sklearn import datasets
from sklearn.cross_validation import train_test_split
from sklearn.cluster import KMeans
from sklearn.metrics import homogeneity_score

# global variables definition
dataset = None
test_size = None
n_clusters = None
init = None
n_init = None
max_iter = None
tol = None
precompute_distances = None
verbose = None
copy_x = None
n_jobs = None
algorithm = None


def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '',
                                      ['dataset=', 'test_size=', 'n_clusters=', 'init=', "n_init=", 'max_iter=',
                                       'tol=', 'precompute_distances=', 'verbose=', 'copy_x=', 'n_jobs=',
                                       'algorithm='])
    except getopt.GetoptError:
        print 'Error when converting arguments.'
        sys.exit(2)
    for opt, arg in optlist:
        if opt == "--dataset":
            global dataset
            dataset = arg

        elif opt == "--test_size":
            global test_size
            test_size = parser.str2float(arg)

        elif opt == "--n_clusters":
            global n_clusters
            n_clusters = parser.str2n_clusters(arg)

        elif opt == "--init":
            global init
            init = parser.str2init(arg)

        elif opt == "--n_init":
            global n_init
            n_init = parser.str2n_init(arg)

        elif opt == "--max_iter":
            global max_iter
            max_iter = parser.str2max_iter(arg)

        elif opt == "--tol":
            global tol
            tol = parser.str2tol(arg)

        elif opt == "--precompute_distances":
            global precompute_distances
            precompute_distances = parser.str2precompute_distances(arg)

        elif opt == "--verbose":
            global verbose
            verbose = parser.str2int(arg)  # todo change this

        elif opt == "--copy_x":
            global copy_x
            copy_x = parser.str2copy_x(arg)

        elif opt == "--n_jobs":
            global n_jobs
            n_jobs = parser.str2n_jobs(arg)

        elif opt == "--algorithm":
            global algorithm
            algorithm = parser.str2algorithm(arg)


def getDataset():
    global dataset
    # load dataset
    if dataset == "iris":
        loaded_dataset = datasets.load_digits()
    elif dataset == "breast_cancer":
        loaded_dataset = datasets.load_breast_cancer()
    elif dataset == "digits":
        loaded_dataset = datasets.load_digits()
    elif dataset == "diabetes":
        loaded_dataset = datasets.load_diabetes()
    elif dataset == "boston":
        loaded_dataset = datasets.load_boston()
    else:
        raise Exception('Dataset is not a valid one. Try iris, breast_cancer or digits.')

    return loaded_dataset


def clustering(loaded_dataset):
    # data_set features
    X = loaded_dataset.data
    # data_set labels
    y = loaded_dataset.target
    # get class names from dataset
    # class_names = loaded_dataset.target_names

    # split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=test_size)

    # declare the classifier
    k_means = KMeans(n_clusters=n_clusters, init=init, n_init=n_init, max_iter=max_iter, tol=tol,
                     precompute_distances=precompute_distances, verbose=verbose, copy_x=copy_x, n_jobs=n_jobs,
                     algorithm=algorithm)

    # fit(train) the classifier
    k_means.fit(X_train)

    # make predictions using the trained classifier
    predictions = k_means.predict(X_test)

    # measure the accuracy of the classifier
    accuracy = homogeneity_score(y_test, predictions)

    # print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": accuracy, "confusion_matrix": None}}, sort_keys=True, separators=(',', ':'))


try:
    getArguments(sys.argv[1:])
    print clustering(getDataset())

except Exception as e:
    print json.dumps({"status": "error", "data": {"error": str(e)}}, sort_keys=True, separators=(',', ':'))
