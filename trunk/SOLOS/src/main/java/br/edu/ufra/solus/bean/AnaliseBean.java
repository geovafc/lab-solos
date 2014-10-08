package br.edu.ufra.solus.bean;

import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.rn.RNFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AnaliseBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(AnaliseBean.class.getName());
    private final GenericRN<Analise> rn = RNFactory.criarAnaliseRN();
    private List<Analise> analises;
    private Analise analise = new Analise();

    public AnaliseBean() {
    }

    public String salvar() {
        try {
            rn.salvar(analise);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            return "lista_analise";
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao salvar", ex);
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(analise);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao remover", ex);
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
