package br.com.mgobo.jsfapplication.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named(value = "cadastros")
public class Cadastros implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String registro;

    public void salvar() {
        System.out.println("Nome: "+this.getNome());
        setRegistro(this.getNome());

        System.out.println("Registros: "+this.getRegistro());
    }

    public String getNome() {
        if (this.nome == null) {
            this.nome = "";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        if (this.registro == null) {
            this.registro = "";
        }
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
