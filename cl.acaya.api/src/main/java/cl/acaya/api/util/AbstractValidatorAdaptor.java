package cl.acaya.api.util;

import cl.acaya.api.i18n.AbstractMultipleMensajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 11/4/13
 * Time: 6:20 PM
 */
public abstract class AbstractValidatorAdaptor<T> implements Validator<T> {

    protected final Locale defaultLocale = new Locale("es", "CL");
    private AbstractMultipleMensajes mensajes;
    private List<String> errors = new ArrayList<String>();

    private AbstractValidatorAdaptor() {
    }

    public AbstractValidatorAdaptor(AbstractMultipleMensajes mensajes) {
        this.mensajes = mensajes;
    }

    private Locale valida(final Locale locale) {
        return locale != null ? locale : defaultLocale;
    }

    protected String getFormattedString(final Locale locale, final String code, final String... args) {
        return mensajes.getFormattedString(valida(locale), code, args);
    }

    protected void addErrorExcedeMaxLength(final Locale locale, final String code, final String valorActual, final String maxLength) {
        addError(mensajes.getFormattedString(valida(locale), "excede.max.len", mensajes.getString(valida(locale), code), valorActual, maxLength));
    }

    protected void addErrorExcedeMaxLength(final Locale locale, final String code, final int valorActual, final int maxLength) {
        addError(mensajes.getFormattedString(valida(locale), "excede.max.len", mensajes.getString(valida(locale), code), valorActual, maxLength));
    }

    protected void addErrNoHasIngresado(final Locale locale, final String code) {
        addError(mensajes.getFormattedString(valida(locale), "no.has.ingresado", mensajes.getString(valida(locale), code)));
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean haveErrors() {
        return errors != null && !errors.isEmpty();
    }

    public void addErrors(final List<String> errors) {
        if (errors != null) {
            this.errors.addAll(errors);
        }
    }

    public void addError(final String error) {
        errors.add(error);
    }

    public void reset() {
        errors.clear();
    }

}
