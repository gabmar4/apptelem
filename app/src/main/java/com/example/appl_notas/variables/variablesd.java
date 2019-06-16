package com.example.appl_notas.variables;

public class variablesd {

    private Double nota_1,nota_2,nota_p,nota_ot,pnota_1,pnota_2,pnota_p,pnota_ot;
    private String asignatura;

    public variablesd(Double nota_1, Double nota_2, Double nota_p, Double nota_ot, Double pnota_1, Double pnota_2, Double pnota_p, Double pnota_ot, String asignatura) {
        this.nota_1 = nota_1;
        this.nota_2 = nota_2;
        this.nota_p = nota_p;
        this.nota_ot = nota_ot;
        this.pnota_1 = pnota_1;
        this.pnota_2 = pnota_2;
        this.pnota_p = pnota_p;
        this.pnota_ot = pnota_ot;
        this.asignatura = asignatura;
    }

    public Double getNota_1() {
        return nota_1;
    }

    public void setNota_1(Double nota_1) {
        this.nota_1 = nota_1;
    }

    public Double getNota_2() {
        return nota_2;
    }

    public void setNota_2(Double nota_2) {
        this.nota_2 = nota_2;
    }

    public Double getNota_p() {
        return nota_p;
    }

    public void setNota_p(Double nota_p) {
        this.nota_p = nota_p;
    }

    public Double getNota_ot() {
        return nota_ot;
    }

    public void setNota_ot(Double nota_ot) {
        this.nota_ot = nota_ot;
    }

    public Double getPnota_1() {
        return pnota_1;
    }

    public void setPnota_1(Double pnota_1) {
        this.pnota_1 = pnota_1;
    }

    public Double getPnota_2() {
        return pnota_2;
    }

    public void setPnota_2(Double pnota_2) {
        this.pnota_2 = pnota_2;
    }

    public Double getPnota_p() {
        return pnota_p;
    }

    public void setPnota_p(Double pnota_p) {
        this.pnota_p = pnota_p;
    }

    public Double getPnota_ot() {
        return pnota_ot;
    }

    public void setPnota_ot(Double pnota_ot) {
        this.pnota_ot = pnota_ot;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
