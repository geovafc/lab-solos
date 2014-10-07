

package br.edu.ufra.solus.bean;

import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.rn.RNFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class AnaliseBean implements Serializable{
    private final GenericRN<Analise> rn = RNFactory.criarAnaliseRN();
    private List<Analise> analises;
    private Analise analise = new Analise();
    public AnaliseBean(){
        
    }

    public String salvar(){
        try {
            rn.salvar(analise);
            return "lista_analise";
        } catch (DAOException ex) {
            Logger.getLogger(AnaliseBean.class.getName()).log(Level.SEVERE, null,ex);
        return null;
        }
    }
    
    public void remover(){
        try {
            rn.remover(analise);
        } catch (DAOException ex) {
            Logger.getLogger(AnaliseBean.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    
    public List<Analise> getAnalises() {
        analises=rn.obterTodos();
        return analises;
    }


    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }
    
}
