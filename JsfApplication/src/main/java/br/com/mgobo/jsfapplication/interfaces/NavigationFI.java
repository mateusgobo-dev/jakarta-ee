package br.com.mgobo.jsfapplication.interfaces;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
public interface NavigationFI {

    Supplier<FacesContext> facesContext = () -> FacesContext.getCurrentInstance();
    Supplier<ExternalContext> externalContext = () -> facesContext.get().getExternalContext();
    Supplier<String> requestPath = () -> externalContext.get().getRequestContextPath();

    Predicate<String> to = page -> page.toLowerCase().contains("template") || page.toLowerCase().contains("index");

    void toPage(String page);

    NavigationFI navigate = (page) -> {
        try {
            externalContext.get().redirect(to.test(page) ? requestPath.get() + "/"+page : requestPath.get() + "/pages/" + page);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    };
}
