package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.dao.AnaliseDAO;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solos.dao.DAOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AnaliseBean implements Serializable {

    private final AnaliseDAO dao = new AnaliseDAO();
    private List<Analise> analises;
    private List<String> tipos;
    private Analise analise = new Analise();

    public AnaliseBean() {
    }

    public String salvar() {
        try {
            dao.salvar(analise);
            JsfUtil.mensagemSalvoComSucesso();
            return "lista_analise";
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            dao.remover(analise);
            JsfUtil.mensagemExcluidoComSucesso();
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
        }
    }

    public List<Analise> getAnalises() {
        analises = dao.obterTodos();
        return analises;
    }

    public List<String> getTipos() {
        if (tipos == null) {
            tipos = new ArrayList<>();
            tipos.add("SOLO");
            tipos.add("PLANTA");
            tipos.add("FÍSICA");
        }
        return tipos;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public List<Analise> obterPorTipo(String tipo) {
        return dao.obterPorTipo(tipo);
    }

}
