package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class FunctionHelperEvaluator {
    public static SExpression eval(Function function, SExpression sExpression, Environment environment) {
        Environment staticEnvironment = function.getEnvironment();
        Environment childEnvironment = staticEnvironment.newChild();
        IdentifierAtom[] formalParameters = function.getLambda().getArgumentNames();
        SExpression actualParameters = sExpression.getTail();

        for (IdentifierAtom formalParameter : formalParameters) {
            SExpression actualParameter = actualParameters.getHead();
            childEnvironment.assign(formalParameter, actualParameter.eval(environment));
            actualParameters = actualParameters.getTail();
            if (actualParameters == null) {
                break;
            }
        }

        return function.getLambda().eval(childEnvironment);
    }
}
