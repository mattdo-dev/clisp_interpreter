package operations;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

import java.util.Vector;

public class LambdaEvaluator implements Evaluator {
    @Override
    public SExpression eval(SExpression sExpression, Environment environment) {
        sExpression = sExpression.getTail();

        Vector<IdentifierAtom> formalParameters = new Vector<>();
        SExpression formals = sExpression.getHead();
        SExpression actualParameters = sExpression.getTail();
        while (!formals.isAtom()) {
            formalParameters.add((IdentifierAtom) formals.getHead());
            formals = formals.getTail();
        }
        return LambdaFactory.newInstance(formalParameters.toArray(new IdentifierAtom[0]), actualParameters);
    }
}
