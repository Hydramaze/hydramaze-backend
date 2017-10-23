import sys
import json
import getopt
import argumentParser as parser
#import data_set
from sklearn import datasets
from sklearn.cross_validation import train_test_split
from sklearn.cluster import KMeans
from sklearn.metrics import homogeneity_score

# global variables definition
dataset = None
test_size = None

def getArguments(argv):
    try:
        optlist, args = getopt.getopt(argv, '', ['dataset=', 'test_size='])
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


def getDataset():
    global dataset
    #load data_set
    # if dataset == "iris":
    loaded_dataset = datasets.load_digits()
    # elif dataset == "breast_cancer":
    #     loaded_dataset = datasets.load_breast_cancer()
    # elif dataset == "digits":
    #     loaded_dataset = datasets.load_digits()
    # else:
    #     raise Exception('Dataset is not a valid one. Try iris, breast_cancer or digits.')

    return loaded_dataset

def clustering(loaded_dataset):
    #data_set features
    X = loaded_dataset.data
    #data_set labels
    y = loaded_dataset.target
    #get class names from dataset
    class_names = loaded_dataset.target_names

    #split data_set (tain and test)
    X_train, X_test, y_train, y_test = train_test_split(X,y,test_size = test_size)

    #declare the classifier
    k_means = KMeans(n_clusters=8, init='k-means++', n_init=10, max_iter=300, tol=0.0001, precompute_distances='auto',
                     verbose=0, random_state=None, copy_x=True, n_jobs=1, algorithm='auto')

    #fit(train) the classifier
    k_means.fit(X_train)

    #make predictions using the trained classifier
    predictions = k_means.predict(X_test)

    #measure the accuracy of the classifier
    accuracy = homogeneity_score(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    return json.dumps({"status": "success", "data": {"accuracy": accuracy,"confusion_matrix": None}}, sort_keys=True, separators=(',',':'))

try:
    # getArguments(sys.argv[1:])
    print clustering(getDataset())

except Exception as e:
    print json.dumps({"status": "error", "data": {"error": str(e)}}, sort_keys=True, separators=(',',':'))





