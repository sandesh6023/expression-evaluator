Expression Evaluator
====================

####HOW TO RUN?
set the environment variable as
    %EVALUATOR_HOME%/bin

####RUNNING COMMAND

`$sh expr_eval.sh "[expression separated by single space]"`
`$sh expr_eval.sh "2 + 3"`

##OPERATORS SUPPORTED IN ALL VERSIONS: *,^,+,/,-
##EXPRESSION WILL BE EVALUATED FROM LEFT TO RIGHT.

#### VERSION 0.1

    ##Product takes only two operands and an operator in between.

        [Constraints]
        operand can only be +ve integers.
        Values should be space separated.
        divide by zero not allowed

    Example: "2 + 3"


#### VERSION 0.2

    ##Product takes multiple operands and operators in between them.

    [The constraints specified for previous version applies to this version also]
    #Product doesnot handle brackets in Expressions.

    Example: expr_eval.sh "2 + 3 * 9" will give 45

#### VERSION 0.3

    ##Product takes multiple operands and operators in between them.
    ##Expression will evaluate brackets in expression
    ##Expression inside brackets are evaluated first.


    [The constraints specified for previous version applies to this version also]
    #Product doesnot handle NESTED brackets in Expressions.

    Example: expr_eval.sh "2 + (3 * 9) + (4 + 2)" will give 37

    There should be no space between bracket and number.
    Example 2 + ( 3 * 5 ) IS NOT ALLOWED

#### VERSION 0.4

    ##Product takes multiple operands and operators in between them.
    ##Expression will evaluate brackets and nested brackets in expression

    [The constraints specified for previous version applies to this version also]

    Example1: expr_eval.sh "2 + ((3 * 9) + (4 + 2) + 1)" will give 37
    Example2: expr_eval.sh  "2 + ((3 * 9) + (3 * 4) + (3 + 3) )" will give 47

    There should be no space
    #between bracket and number.
    #two successive open brackets.

    Example 2 + (  ( 3 * 5 ) + 1) IS NOT ALLOWED

#### VERSION 0.5
    ##The product will handle float and Negative numbers.

#### VERSION 0.6
    ##The product will handle spaces and wrong inputs with brackests are validated.