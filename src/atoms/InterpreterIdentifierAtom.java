package atoms;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.Token;

public class InterpreterIdentifierAtom extends IdentifierAtom {
    public InterpreterIdentifierAtom(Token token) {
        super(token);
    }

    @Override
    public SExpression eval(Environment environment) {
        return environment.lookup(this).isPresent() ? environment.lookup(this).get() : this;
    }
}
