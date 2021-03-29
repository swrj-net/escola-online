package com.swrj.net.escolaonline.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.swrj.net.escolaonline.domain.enumeration.SituacaoDebito;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A HistoricoDebito.
 */
@Entity
@Table(name = "historico_debito")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HistoricoDebito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_debito")
    private SituacaoDebito situacaoDebito;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "valor_original", precision = 21, scale = 2)
    private BigDecimal valorOriginal;

    @Column(name = "total_pago", precision = 21, scale = 2)
    private BigDecimal totalPago;

    @Column(name = "total_desconto", precision = 21, scale = 2)
    private BigDecimal totalDesconto;

    @Column(name = "total_devido", precision = 21, scale = 2)
    private BigDecimal totalDevido;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JsonIgnoreProperties(value = { "historicoDebitos", "alunoDebito" }, allowSetters = true)
    private Debito debitoHistoricoDebito;

    @ManyToOne
    @JsonIgnoreProperties(value = { "historicoDebitos" }, allowSetters = true)
    private DetalheUsuario detalheUsuarioLancamento;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HistoricoDebito id(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public HistoricoDebito dataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public SituacaoDebito getSituacaoDebito() {
        return this.situacaoDebito;
    }

    public HistoricoDebito situacaoDebito(SituacaoDebito situacaoDebito) {
        this.situacaoDebito = situacaoDebito;
        return this;
    }

    public void setSituacaoDebito(SituacaoDebito situacaoDebito) {
        this.situacaoDebito = situacaoDebito;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public HistoricoDebito dataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public HistoricoDebito dataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorOriginal() {
        return this.valorOriginal;
    }

    public HistoricoDebito valorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
        return this;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getTotalPago() {
        return this.totalPago;
    }

    public HistoricoDebito totalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
        return this;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public BigDecimal getTotalDesconto() {
        return this.totalDesconto;
    }

    public HistoricoDebito totalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
        return this;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public BigDecimal getTotalDevido() {
        return this.totalDevido;
    }

    public HistoricoDebito totalDevido(BigDecimal totalDevido) {
        this.totalDevido = totalDevido;
        return this;
    }

    public void setTotalDevido(BigDecimal totalDevido) {
        this.totalDevido = totalDevido;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public HistoricoDebito observacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Debito getDebitoHistoricoDebito() {
        return this.debitoHistoricoDebito;
    }

    public HistoricoDebito debitoHistoricoDebito(Debito debito) {
        this.setDebitoHistoricoDebito(debito);
        return this;
    }

    public void setDebitoHistoricoDebito(Debito debito) {
        this.debitoHistoricoDebito = debito;
    }

    public DetalheUsuario getDetalheUsuarioLancamento() {
        return this.detalheUsuarioLancamento;
    }

    public HistoricoDebito detalheUsuarioLancamento(DetalheUsuario detalheUsuario) {
        this.setDetalheUsuarioLancamento(detalheUsuario);
        return this;
    }

    public void setDetalheUsuarioLancamento(DetalheUsuario detalheUsuario) {
        this.detalheUsuarioLancamento = detalheUsuario;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoricoDebito)) {
            return false;
        }
        return id != null && id.equals(((HistoricoDebito) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoricoDebito{" +
            "id=" + getId() +
            ", dataLancamento='" + getDataLancamento() + "'" +
            ", situacaoDebito='" + getSituacaoDebito() + "'" +
            ", dataVencimento='" + getDataVencimento() + "'" +
            ", dataPagamento='" + getDataPagamento() + "'" +
            ", valorOriginal=" + getValorOriginal() +
            ", totalPago=" + getTotalPago() +
            ", totalDesconto=" + getTotalDesconto() +
            ", totalDevido=" + getTotalDevido() +
            ", observacoes='" + getObservacoes() + "'" +
            "}";
    }
}
