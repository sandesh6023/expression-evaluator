Expression Evaluator
====================

####HOW TO RUN?
set the environment variable as
    %EVALUATOR_HOME%/bin

####RUNNING COMMAND

`$sh expr_eval.sh "[expression separated by single space]"`
`$sh expr_eval.sh "2 + 3"`

#### VERSION 0.1

    ##Product takes only two operands and an operator in between.

        [Constraints]
        operator can be only ‘+’ ,'-','*','/','^'
        operand can only be +ve integers.
        Values should be space separated.
        divide by zero not allowed

    Example: "2 + 3"


#### VERSION 0.2

    ##Product takes multiple operands and operators in between them.
    ##Expression will be evaluated From Left to Right

    [The constraints specified for previous version applies to this version also]
    Product doesnot handle brackets in Expressions.

    Example: expr_eval.sh "2 + 3 * 9" will give 45
