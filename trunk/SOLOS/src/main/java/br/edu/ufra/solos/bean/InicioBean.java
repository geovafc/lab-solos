/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Solicitacao;
import br.edu.ufra.solos.rn.SolicitacaoRN;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 *
 * @author Dedo
 */
@ViewScoped
@ManagedBean
public class InicioBean {

    private final SolicitacaoRN rn = new SolicitacaoRN();
    private TimelineModel timelineModel;

    @PostConstruct
    public void init() {
        List<Solicitacao> solicitacoes = rn.obterTodos();
        if (solicitacoes == null || solicitacoes.isEmpty()) return;
        List<TimelineEvent> events = new ArrayList<>();
        for (Solicitacao solicitacao : solicitacoes) {
            TimelineEvent timelineEvent = new TimelineEvent(solicitacao.getProprietario().getNome(),
                    solicitacao.getDataDeSaida());
            events.add(timelineEvent);
        }
        timelineModel = new TimelineModel(events);
    }

    public TimelineModel getTimelineModel() {
        return timelineModel;
    }

}
