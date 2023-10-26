package environment;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

import java.util.Optional;

public class InterpreterEnvironment extends AbstractEnvironment {

    public InterpreterEnvironment() {
        super();
    }
    public InterpreterEnvironment(Environment parent) {
        super(parent);
    }

    @Override
    public Optional<SExpression> lookup(IdentifierAtom identifierAtom) {
        return get(identifierAtom);
    }

    @Override
    public Optional<Function> lookupFun(IdentifierAtom identifierAtom) {
        return getFun(identifierAtom);
    }

    @Override
    public void assign(IdentifierAtom identifierAtom, SExpression sExpression) {
        put(identifierAtom, sExpression);
    }

    @Override
    public void assignFun(IdentifierAtom identifierAtom, Function function) {
        putFun(identifierAtom, function);
    }

    @Override
    public Environment newChild() {
        return new InterpreterEnvironment(getParent());
    }

    @Override
    public Environment copy() {
        return new InterpreterEnvironment(getParent());
    }
}
