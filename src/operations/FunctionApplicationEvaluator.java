package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.SExpression;

public class FunctionApplicationEvaluator implements Evaluator {
    /* --
        otherwise known as FUNCALL
     */
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        sExpression = sExpression.getTail();

        SExpression lambdaOrFunction = sExpression.getHead().eval(environment);

        if (lambdaOrFunction instanceof Lambda) {
            return LambdaHelperEvaluator.eval((Lambda) lambdaOrFunction, sExpression, environment);
        } else {
            return FunctionHelperEvaluator.eval((Function) lambdaOrFunction, sExpression, environment);
        }
    }
}
