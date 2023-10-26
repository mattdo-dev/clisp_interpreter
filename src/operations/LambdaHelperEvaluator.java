package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class LambdaHelperEvaluator {
    public static SExpression eval(Lambda lambda, SExpression sExpression, Environment environment) {
        Environment child = environment.newChild();
        IdentifierAtom[] formalParameters = lambda.getArgumentNames();
        SExpression actualParameters = sExpression.getTail();

        for (IdentifierAtom formalParameter : formalParameters) {
            SExpression actualParameter = actualParameters.getHead();
            child.assign(formalParameter, actualParameter.eval(environment));
            actualParameters = actualParameters.getTail();
            if (actualParameters == null) {
                break;
            }
        }

        return lambda.eval(child);
    }
}
