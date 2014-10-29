package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.rn.RNFactory;
import br.edu.ufra.solos.rn.GenericRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AnaliseBean implements Serializable {

    private final GenericRN<Analise> rn = RNFactory.criarGenericRN(Analise.class);
    private List<Analise> analises;
    private Analise analise = new Analise();

    public AnaliseBean() {
    }

    public String salvar() {
        try {
            rn.salvar(analise);
            JsfUtil.mensagemSalvoComSucesso();
            return "lista_analise";
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(analise);
            JsfUtil.mensagemExcluidoComSucesso();
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
        }
    }

    public List<Analise> getAnalises() {
        analises = rn.obterTodos();
        return analises;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

}
