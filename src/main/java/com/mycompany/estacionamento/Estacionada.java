package com.mycompany.estacionamento;
import java.util.Date;
import com.mycompany.estacionamento.Carro;
import com.mycompany.estacionamento.Moto;


public class Estacionada {
    public static int id;
    private Date entrada, saida;
    private Vaga vaga;
    private Veiculo veiculo;
    private double valor;
    
    public Estacionada(Date entrada, Vaga vaga, Veiculo veiculo){
        this.entrada = entrada;
        this.vaga = vaga;
        this.veiculo = veiculo;
        id++;
    }
    
    public int getId(){
        return id;
    }
    
    public Date getEntrada(){
        return entrada;
    }
    
    public Date getSaida(){
        return saida;
    }
    
    public Vaga getVaga(){
        return vaga;
    }
    
    public Veiculo getVeiculo(){
        return veiculo;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setEntrada(Date entrada){
        this.entrada = entrada;
    }
    
    public void setVaga(Vaga vaga){
        this.vaga = vaga;
    }
    
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    
    public void setValor(double valor){
        this.valor = valor;
        
    }
    
    public void setSaida(Date saida){
        this.saida = saida;
        double tempoHoras = Math.ceil((saida.getTime() - entrada.getTime())/(1000.0 * 60 * 60));
        
        if (veiculo instanceof Carro){
            valor=tempoHoras*4;
        }else if (veiculo instanceof Moto){
            valor=tempoHoras*2;            
        }else{
            valor=0;
        }
        
    }
}
