package operations;

import main.lisp.evaluator.Environment;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.parser.terms.NilAtomFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.TAtomicExpressionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadEvaluator extends UniqueEvaluator {
    @Override
    public SExpression eval(final SExpression sExpression, final Environment environment) {
        final SExpression toCheck = sExpression.getTail();
        final StringAtom fileName = (StringAtom) toCheck.getHead();
        final List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName.getValue()));
        } catch (IOException e) {
            return NilAtomFactory.newInstance();
        }
        for (String line : lines) {
            try {
                InterpreterModelSingleton.get().newInput(line);
            } catch (Exception e) {
                return NilAtomFactory.newInstance();
            }
        }
        return TAtomicExpressionFactory.newInstance();
    }
}
