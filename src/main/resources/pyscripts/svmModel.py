import sys

#TODO corrigir random_state_value
def classifier(c_value, cache_size_value, class_weight_value, coef0_value, decision_function_shape_value, degree_value, gamma_value, kernel_value,
              max_iter_value, probability_value, random_state_value, shrinking_value, tol_value, verbose_value):
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
    my_classifier = SVC(C=c_value, cache_size=cache_size_value, class_weight=class_weight_value, coef0=coef0_value,
                        decision_function_shape=decision_function_shape_value, degree=degree_value, gamma=gamma_value, kernel=kernel_value,
                        max_iter=max_iter_value, probability=probability_value, random_state=None, shrinking=shrinking_value,
                        tol=tol_value, verbose=verbose_value)

    #fit(train) the classifier
    my_classifier.fit(X_train, y_train)

    #make predictions using the trained classifier
    predictions = my_classifier.predict(X_test)

    #measure the accuracy of the classifier
    accuracy = accuracy_score(y_test, predictions)

    #print results (the last line will be used as a json return to the java class)
    # print "teste"
    return accuracy
    # print "Teste realizado com sucesso!"
    # print json.dumps({"data": X.tolist(), "target": y.tolist(), "status": "success"}, sort_keys=True, separators=(',',':'))


#get the arguments from the console command line (!!!!!!!!WARNING!!!!!!!!!! : must be in order)

c = float(sys.argv[1])
cache_size = float(sys.argv[2])
class_weight = None
#coef0
try:
    coef0 = float(sys.argv[4])
except:
    coef0 = sys.argv[4]

decision_function_shape = None
#degree
try:
    degree = int(sys.argv[6])
except:
    degree = sys.argv[6]
#gamma
try:
    gamma = float(sys.argv[7])
except:
    gamma = sys.argv[7]

kernel = sys.argv[8]
max_iter = int(sys.argv[9])
probability = (sys.argv[10] == 'True')
#random_state
try:
    random_state = float(sys.argv[11])
except:
    random_state = sys.argv[11]
shrinking = (sys.argv[12] == 'True')
tol = float(sys.argv[13])
verbose = (sys.argv[14] == 'True')

print sys.argv

result = classifier(c, cache_size, class_weight, coef0, decision_function_shape, degree, gamma, kernel, max_iter, probability, random_state, shrinking, tol, verbose)

print result


