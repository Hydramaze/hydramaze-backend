import argparse

"""
Parser script to be used in the project 
"""

"""
*****************  Primitive types argument parser ***************** 
"""
# @Param value string to be converted to boolean
# @return boolean value, raises ArgumentTypeError if isn't parseble
def str2bool(value):
    if value.lower() in ('yes', 'true' , 't', 'y', '1'):
        return True
    elif value.lower() in ('no', 'false', 'f', 'n', '0'):
        return False
    else:
        raise argparse.ArgumentTypeError('Boolean value expected.')

# @Param value string to be converted to integer
# @return integer value, raises ArgumentTypeError if isn't parseble
def str2int(value):
    try:
        return int(value)
    except:
        raise argparse.ArgumentTypeError('Integer value expected.')

# @Param value string to be converted to integer
# @return integer value, raises ArgumentTypeError if isn't parseble
def str2float(value):
    try:
        return float(value)
    except:
        raise argparse.ArgumentTypeError('Float value expected.')

"""
***************** SVC parameters types argument parser ***************** 
"""

# @Param value string to be converted to kernel
# @return a valid kernel value, raises ArgumentTypeError if isn't parseble
def str2kernel(value):
    if(value.lower() == "rbf" or value.lower()== "linear" or
           value.lower() == "poly" or value.lower() == "sigmoid"):
        return value
    else:
        raise argparse.ArgumentTypeError('kernel value expected. Must be: rbf, linear, poly or sigmoid')


# @Param value string to be converted to C
# @return a valid C value, raises ArgumentTypeError if isn't parseble
def str2C(value):
    try:
        C = str2float(value)
        if (C >= 0):
            return C
        else:
            raise argparse.ArgumentTypeError('C value expected. Must be a positive float')
    except:
        raise argparse.ArgumentTypeError('C value expected. Must be a positive float')

# @Param value string to be converted to cache_size
# @return a valid cache_size value, raises ArgumentTypeError if isn't parseble
def str2cache_size(value):
    try:
        cache = str2float(value)
        if (cache >= 0):
            return cache
        else:
            raise argparse.ArgumentTypeError('cache_size value expected. Must be a positive float')
    except:
        raise argparse.ArgumentTypeError('cache_size value expected. Must be a positive float')
# @Param value string to be converted to coef0
# @return a valid Coef0 value, raises ArgumentTypeError if isn't parseble
def str2Coef0(value):
    try:
        return str2float(value)
    except:
        raise argparse.ArgumentTypeError('Coef0 value expected. Must be a float')
# @Param value string to be converted to degree
# @return a valid Degree value, raises ArgumentTypeError if isn't parseble
def str2degree(value):
    try:
        degree = str2int(value)
        if (degree > 0):
            return degree
        else:
            raise argparse.ArgumentTypeError('degree value expected. Must be a positive non zero integer')
    except:
        raise argparse.ArgumentTypeError('degree value expected. Must be a positive non zero integer')

# @Param value string to be converted to gamma
# @return a valid Gamma value, raises ArgumentTypeError if isn't parseble
def str2gamma(value):
    try:
        return str2float(value)
    except:
        if(value == 'auto'):
            return value
        else:
            raise argparse.ArgumentTypeError('gamma value expected. Must be a float or \'auto\'')


# @Param value string to be converted to max_iter
# @return a valid max_iter value, raises ArgumentTypeError if isn't parseble
def str2max_iter(value):
    try:
        max_iter = str2int(value)
        if (max_iter >= -1):
            return max_iter
        else:
            raise argparse.ArgumentTypeError('max_iter value expected. Must be a positive integer or -1(represents infinity)')
    except:
        raise argparse.ArgumentTypeError('max_iter value expected. Must be a positive integer or -1(represents infinity)')


# @Param value string to be converted to probability
# @return a valid probability value, raises ArgumentTypeError if isn't parseble
def str2probability(value):
    try:
        return str2bool(value)
    except:
        raise argparse.ArgumentTypeError('probability value expected. Must be a boolean')

# @Param value string to be converted to shrinking
# @return a valid shrinking value, raises ArgumentTypeError if isn't parseble
def str2shrinking(value):
    try:
        return str2bool(value)
    except:
        raise argparse.ArgumentTypeError('shrinking value expected. Must be a boolean')

# @Param value string to be converted to tol
# @return a valid tol value, raises ArgumentTypeError if isn't parseble
def str2tol(value):
    try:
        return str2float(value)
    except:
        raise argparse.ArgumentTypeError('tol value expected. Must be a float')
# @Param value string to be converted to verbose
# @return a valid verbose value, raises ArgumentTypeError if isn't parseble
def str2verbose(value):
    try:
        return str2bool(value)
    except:
        raise argparse.ArgumentTypeError('verbose value expected. Must be a boolean')