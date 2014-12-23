/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.SolicitacaoDAO;
import br.edu.ufra.solos.entidade.Amostra;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.entidade.Faturamento;
import br.edu.ufra.solos.entidade.Solicitacao;
import br.edu.ufra.solos.util.DateUtil;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dedo
 */
public class SolicitacaoRN implements Serializable {

    private final SolicitacaoDAO dao = new SolicitacaoDAO();

    public void salvar(Solicitacao entidade) throws DAOException {
        dao.salvar(entidade);
    }

    public void remover(Solicitacao entidade) throws DAOException {
        dao.remover(entidade);
    }

    public void salvarNoContexto(Object object) {
        dao.salvarNoContext(object);
    }

    public void removerDoContexto(Object object) {
        dao.removerDoContext(object);
    }

    public List<Faturamento> montarFaturamento(List<Analise> analises, Amostra amostra) {
        List<Faturamento> lista = new ArrayList<>();
        for (Analise analise : analises) {
            Faturamento f = new Faturamento();
            f.setAmostra(amostra);
            f.setAnalise(analise);
            f.setPreco(analise.getPreco());
            lista.add(f);
        }
        return lista;
    }

    public Amostra reaproveitarAmostra(Amostra amostra) {
        Amostra clonada = new Amostra();
        clonada.setCodigo(gerarCodigo());
        clonada.setArea(amostra.getArea());
        clonada.setLocal(amostra.getLocal());
        clonada.setPosicaoDoRelevo(amostra.getPosicaoDoRelevo());
        clonada.setProfundidade(amostra.getProfundidade());
        clonada.setRelevo(amostra.getRelevo());
        clonada.setTipoDeCobertura(amostra.getTipoDeCobertura());
        clonada.setTipo(amostra.getTipo());
        clonada.setSolicitacao(amostra.getSolicitacao());
        for (Faturamento f : amostra.getFaturamentoList()) {
            Faturamento fClonado = new Faturamento();
            fClonado.setAmostra(clonada);
            fClonado.setAnalise(f.getAnalise());
            fClonado.setPreco(f.getPreco());
            fClonado.setValorDeDesconto(f.getValorDeDesconto());
            fClonado.setTipoDeDesconto(f.getTipoDeDesconto());
            clonada.getFaturamentoList().add(fClonado);
        }
        return clonada;
    }
    
    public List<Analise> filtrarPorTipoDeAmostra(List<Analise> analises, String tipo) {
        if (analises == null || tipo == null) return Collections.EMPTY_LIST;
        List<Analise> filtrada = new ArrayList<>();
        for (Analise analise : analises) {
            if (analise.getTipo().equals(tipo)) {
                filtrada.add(analise);
            }
        }
        return filtrada;
    }

    public String gerarCodigo() {
        int aleatorio = (int) (Math.random() * 1000);
        int ano = new Date().getYear();
        return aleatorio + "" + ano;
    }

    public Date calcular10DiasUteis(Date inicio) {
        LocalDateTime inicioLD = DateUtil.converterDateToLocalDateTime(inicio);
        final int DIAS_UTEIS = 10;
        int ct = 0;
        while (ct != DIAS_UTEIS) {
            inicioLD = inicioLD.plusDays(1);
            DayOfWeek atual = inicioLD.getDayOfWeek();
            if (!(atual == DayOfWeek.SUNDAY || atual == DayOfWeek.SATURDAY)) {
                ct++;
            }
        }
        return DateUtil.converterLocalDateTimeToDate(inicioLD);
    }

    public Solicitacao obter(Object id) {
        return dao.obter(id);
    }

    public List<Solicitacao> obterTodos() {
        return dao.obterTodos();
    }

}
