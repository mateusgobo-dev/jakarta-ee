package br.com.mgobo.jsfapplication.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

import static br.com.mgobo.jsfapplication.interfaces.NavigationFI.navigate;

@ViewScoped
@Named("navigation")
public class Navigation implements Serializable {
    private static final long serialVersionUID = 1L;

    public void to(String page) {
        navigate.toPage(page+".jsf");
    }
}
