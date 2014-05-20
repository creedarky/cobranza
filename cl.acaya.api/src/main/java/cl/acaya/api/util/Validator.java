package cl.acaya.api.util;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 11/4/13
 * Time: 6:19 PM
 */
public interface Validator<T> {

    boolean haveErrors();

    List<String> getErrors();

    Boolean validationIsFine(Locale locale, T item);

    void addError(String error);

    void addErrors(List<String> errors);

    void reset();
}
